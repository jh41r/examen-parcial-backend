package pe.edu.upeu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Usuarios;

public interface UsuariosService {
	Usuarios create(Usuarios u);
	Usuarios update(Usuarios u);
	void delete(Long id);
	Optional<Usuarios> read(Long id);
	List<Usuarios> readAll();
	Usuarios createUsuarioRol(Long usuarioId, Long rolId);
}
