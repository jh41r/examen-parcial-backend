package pe.edu.upeu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Lectores;

public interface LectoresService {
	Lectores create(Lectores l);
	Lectores update(Lectores l);
	void delete(Long id);
	Optional<Lectores> read(Long id);
	List<Lectores> readAll();
}
