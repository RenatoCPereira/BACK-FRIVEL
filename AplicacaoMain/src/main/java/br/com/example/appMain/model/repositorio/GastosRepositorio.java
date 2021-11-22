package br.com.example.appMain.model.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.example.appMain.model.entidades.Gastos;

public interface GastosRepositorio extends PagingAndSortingRepository<Gastos, Integer>{

}
