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

import br.com.example.appMain.model.entidades.Receita;
import br.com.example.appMain.model.entidades.Usuario;
import br.com.example.appMain.model.repositorio.ReceitaRepositorio;

@RestController
@RequestMapping("api/receita")
public class ReceitaControle {
	
	@Autowired
	private ReceitaRepositorio receitaRepositorio;
	
	@PostMapping("/novareceita")
	public @ResponseBody Receita novaReceita(@Valid Receita receita) {
		receitaRepositorio.save(receita);
		return receita;
	}
	
	@GetMapping("obterreceitas")
	public Iterable<Receita> obterReceitas(){
		return receitaRepositorio.findAll();
		
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Receita> obterReceitasId(@PathVariable int id){
		return receitaRepositorio.findById(id);
		
	}
	
	@PutMapping("/alterarreceita")
	public @ResponseBody Receita alterarReceita(@Valid Receita receita) {
		receitaRepositorio.save(receita);
		return receita;
		
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirReceitaId(@PathVariable int id) {
		receitaRepositorio.deleteById(id);
	}

	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Receita> obterReceitaPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5)
			qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return receitaRepositorio.findAll(page);
	}

}
