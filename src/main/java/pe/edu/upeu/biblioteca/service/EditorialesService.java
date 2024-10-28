package pe.edu.upeu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Editoriales;

public interface EditorialesService {
	Editoriales create(Editoriales e);
	Editoriales update(Editoriales e);
	void delete(Long id);
	Optional<Editoriales> read(Long id);
	List<Editoriales> readAll();
}
