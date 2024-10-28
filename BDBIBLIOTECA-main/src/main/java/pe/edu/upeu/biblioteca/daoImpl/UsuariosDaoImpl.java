package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.UsuariosDao;
import pe.edu.upeu.biblioteca.entity.Rol;
import pe.edu.upeu.biblioteca.entity.Usuarios;
import pe.edu.upeu.biblioteca.repository.RolRepository;
import pe.edu.upeu.biblioteca.repository.UsuariosRepository;
@Component
public class UsuariosDaoImpl implements UsuariosDao{
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired 
	private RolRepository rolRepository;
	@Override
	public Usuarios create(Usuarios u) {
		// TODO Auto-generated method stub
		return usuariosRepository.save(u);
	}

	@Override
	public Usuarios update(Usuarios u) {
		// TODO Auto-generated method stub
		return usuariosRepository.save(u);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuariosRepository.deleteById(id);
	}

	@Override
	public Optional<Usuarios> read(Long id) {
		// TODO Auto-generated method stub
		return usuariosRepository.findById(id);
	}

	@Override
	public List<Usuarios> readAll() {
		// TODO Auto-generated method stub
		return usuariosRepository.findAll();
	}

	@Override
	public Usuarios registrarUsuarioRol(Long usuarioId, Long rolId) {
		// TODO Auto-generated method stub
		Usuarios us = usuariosRepository.findById(usuarioId).get();
		Rol ro = rolRepository.findById(rolId).get();

		us.getRols().add(ro);
		ro.getUsuarios().add(us);

		return usuariosRepository.save(us);
	}

}
