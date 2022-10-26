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

import br.com.example.appMain.model.entidades.Gastos;
import br.com.example.appMain.model.repositorio.GastosRepositorio;

@RestController
@RequestMapping("/gastos")
public class GastosControle {
	
	@Autowired
	private GastosRepositorio gastosRepositorio;
	
	@PostMapping("/novogastos")
	public @ResponseBody Gastos novoGastos(@Valid Gastos gastos) {
		gastosRepositorio.save(gastos);
		return gastos;
	}
	
	@GetMapping("obtergastos")
	public Iterable<Gastos> obterGastos() {
		return gastosRepositorio.findAll();

	}
	
	@GetMapping(path = "/{id}")
	public Optional<Gastos> obterGastosId(@PathVariable int id){
		return gastosRepositorio.findById(id);
		
	}
	@PutMapping("/alterarmeta")
	public @ResponseBody Gastos alterarGasto(@Valid Gastos gastos) {
		gastosRepositorio.save(gastos);
		return gastos;
		
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirGastosId(@PathVariable int id) {
		gastosRepositorio.deleteById(id);
	}
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Gastos> obterGastosPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5)
			qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return gastosRepositorio.findAll(page);
	}


}
