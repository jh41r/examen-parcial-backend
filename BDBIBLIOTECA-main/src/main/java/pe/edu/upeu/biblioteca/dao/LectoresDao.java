package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Lectores;

public interface LectoresDao {
	Lectores create(Lectores l);
	Lectores update(Lectores l);
	void delete(Long id);
	Optional<Lectores> read(Long id);
	List<Lectores> readAll();
}
