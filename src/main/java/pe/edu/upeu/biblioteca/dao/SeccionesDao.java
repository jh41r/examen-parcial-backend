package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Secciones;

public interface SeccionesDao {
	Secciones create(Secciones s);
	Secciones update(Secciones s);
	void delete(Long id);
	Optional<Secciones> read(Long id);
	List<Secciones> readAll();
}
