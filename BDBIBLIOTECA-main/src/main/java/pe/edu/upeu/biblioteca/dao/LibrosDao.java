package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Libros;

public interface LibrosDao {
	Libros create(Libros l);
	Libros update(Libros l);
	void delete(Long id);
	Optional<Libros> read(Long id);
	List<Libros> readAll();
	Libros registrarLibroAutor(Long libroId, Long autorId);
}
