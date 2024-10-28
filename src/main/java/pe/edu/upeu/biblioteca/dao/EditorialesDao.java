package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Editoriales;

public interface EditorialesDao {
	Editoriales create(Editoriales e);
	Editoriales update(Editoriales e);
	void delete(Long id);
	Optional<Editoriales> read(Long id);
	List<Editoriales> readAll();
}
