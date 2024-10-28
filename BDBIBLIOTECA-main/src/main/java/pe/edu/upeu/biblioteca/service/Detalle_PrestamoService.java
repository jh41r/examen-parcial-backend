package pe.edu.upeu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Detalle_Prestamo;

public interface Detalle_PrestamoService {
	Detalle_Prestamo create(Detalle_Prestamo d);
	Detalle_Prestamo update(Detalle_Prestamo d);
	void delete(Long id);
	Optional<Detalle_Prestamo> read(Long id);
	List<Detalle_Prestamo> readAll();
}
