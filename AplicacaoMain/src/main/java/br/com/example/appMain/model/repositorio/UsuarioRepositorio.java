package br.com.example.appMain.model.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.example.appMain.model.entidades.Usuario;

public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Integer> {

	public Iterable<Usuario> findByNomeContainingIgnoreCase(String parteNome);

}
