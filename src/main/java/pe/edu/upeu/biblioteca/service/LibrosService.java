package pe.edu.upeu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Libros;

public interface LibrosService {
	Libros create(Libros l);
	Libros update(Libros l);
	void delete(Long id);
	Optional<Libros> read(Long id);
	List<Libros> readAll();
	Libros createLibroAutor(Long libroId, Long autorId);
}
