package br.com.example.appMain.model.repositorio;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.example.appMain.model.entidades.Usuario;

public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Integer> {

	public Iterable<Usuario> findByNomeContainingIgnoreCase(String parteNome);
	
	public Optional<Usuario> findByEmailAndSenha(String login, String senha);

}
