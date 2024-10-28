package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Categorias;

public interface CategoriasDao {
	Categorias create(Categorias c);
	Categorias update(Categorias c);
	void delete(Long id);
	Optional<Categorias> read(Long id);
	List<Categorias> readAll();
}
