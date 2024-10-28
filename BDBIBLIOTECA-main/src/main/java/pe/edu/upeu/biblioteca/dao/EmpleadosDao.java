package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.biblioteca.entity.Empleados;

public interface EmpleadosDao {
	Empleados create(Empleados e);
	Empleados update(Empleados e);
	void delete(Long id);
	Optional<Empleados> read(Long id);
	List<Empleados> readAll();
}
