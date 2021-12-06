package br.com.example.appMain.controle;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.appMain.model.entidades.Usuario;
import br.com.example.appMain.model.repositorio.UsuarioRepositorio;

// CHAMADA DA CLASSE
@RestController
@RequestMapping("/api/usuario")
public class UsuarioControle {

	private static final int Usuario = 0;
	// INSTANCIANDO O REPOSITORIO
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	// CHAMADA DO METODO PARA INCLUIR USUARIO
	@PostMapping("/novousuario")
	public @ResponseBody Usuario novoUsuario(@Valid Usuario usuario) {
		usuarioRepositorio.save(usuario);
		return usuario;

	}

	// CHAMADA DO METODO PARA OBTER TODOS OS USUARIOS
	@GetMapping("/obterusuarios")
	public Iterable<Usuario> obterUsuarios() {
		return usuarioRepositorio.findAll();

	}

	// CHAMADA DO METODO PELO IDENTIFICADOR
	@GetMapping(path = "/{id}")
	public Optional<Usuario> obterUsuarioId(@PathVariable int id) {
		return usuarioRepositorio.findById(id);
	}

	// CHAMADA DO METODO PARA ALTERAR USUARIO
	@PutMapping("/alterarusuario")
	public @ResponseBody Usuario alterarUsuario(@Valid Usuario usuario) {
		usuarioRepositorio.save(usuario);
		return usuario;

	}

	// CHAMADA DO METODO PARA DELETAR USUARIO
	@DeleteMapping(path = "/{id}")
	public void excluirUsuarioId(@PathVariable int id) {
		usuarioRepositorio.deleteById(id);
	}

	// CHAMADA DO METODO PARA COLOCAR A QUANTIDADE DE USUARIO POR PAGINA
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Usuario> obterUsuarioPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5)
			qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return usuarioRepositorio.findAll(page);
	}

	// CHAMADA DO METODO PARA LOCALIZAR USUARIO PELO NOME
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Usuario> obterUsuariosNome(@PathVariable String parteNome) {
		return usuarioRepositorio.findByNomeContainingIgnoreCase(parteNome);

	}

	//// CHAMADA DO METODO LOGIN
	@GetMapping(path = "/{login}/{senha}")
	public Optional<Usuario> logar(@PathVariable String login, @PathVariable String senha) {
		Optional<Usuario> usu = usuarioRepositorio.findByEmailAndSenha(login, senha);
		return usu;

	}

}
