package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Prestamos;

public interface PrestamosDao {
	Prestamos create(Prestamos p);
	Prestamos update(Prestamos p);
	void delete(Long id);
	Optional<Prestamos> read(Long id);
	List<Prestamos> readAll();
}
