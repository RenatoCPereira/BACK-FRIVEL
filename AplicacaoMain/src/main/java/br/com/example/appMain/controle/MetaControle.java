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

import br.com.example.appMain.model.entidades.Meta;
import br.com.example.appMain.model.repositorio.MetaRepositorio;

//CHAMADA DA CLASSE
@RestController
@RequestMapping("/metas")
public class MetaControle {

	// INSTANCIANDO O REPOSITORIO
	@Autowired
	private MetaRepositorio metaRepositorio;

	// CHAMADA DO METODO PARA INCLUIR META
	@PostMapping("/novameta")
	public @ResponseBody Meta novaMeta(@Valid Meta meta) {
		metaRepositorio.save(meta);
		return meta;
	}

	// CHAMADA DO METODO PARA OBTER TODAS AS METAS
	@GetMapping("/obtermetas")
	public Iterable<Meta> obterMetas() {
		return metaRepositorio.findAll();

	}
	
	// CHAMADA DO METODO PELO IDENTIFICADOR
	@GetMapping(path = "/{id}")
	public Optional<Meta> obterMetasId(@PathVariable int id){
		return metaRepositorio.findById(id);
		
	}
	
	// CHAMADA DO METODO PARA ALTERAR META
	@PutMapping("/alterarmeta")
	public @ResponseBody Meta alterarMeta(@Valid Meta meta) {
		metaRepositorio.save(meta);
		return meta;
		
	}
	
	// CHAMADA DO METODO PARA DELETAR META
	@DeleteMapping(path = "/{id}")
	public void excluirMetaId(@PathVariable int id) {
		metaRepositorio.deleteById(id);
	}
	
	
	// CHAMADA DO METODO PARA COLOCAR A QUANTIDADE DE METAS POR PAGINA
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Meta> obterMetaPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5)
			qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return metaRepositorio.findAll(page);
	}


}
