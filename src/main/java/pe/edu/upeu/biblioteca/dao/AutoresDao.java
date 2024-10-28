package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Autores;

public interface AutoresDao {
	Autores create(Autores a);
	Autores update(Autores a);
	void delete(Long id);
	Optional<Autores> read(Long id);
	List<Autores> readAll();
}
