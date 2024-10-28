package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Usuarios;

public interface UsuariosDao {
	Usuarios create(Usuarios u);
	Usuarios update(Usuarios u);
	void delete(Long id);
	Optional<Usuarios> read(Long id);
	List<Usuarios> readAll();
	Usuarios registrarUsuarioRol(Long usuarioId, Long rolId);
}
