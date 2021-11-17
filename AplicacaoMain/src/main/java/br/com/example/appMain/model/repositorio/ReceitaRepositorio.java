package br.com.example.appMain.model.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.example.appMain.model.entidades.Receita;

public interface ReceitaRepositorio extends PagingAndSortingRepository<Receita, Integer> {
	


}
