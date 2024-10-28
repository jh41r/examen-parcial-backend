package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.AccesoDao;
import pe.edu.upeu.biblioteca.entity.Acceso;
import pe.edu.upeu.biblioteca.entity.Rol;
import pe.edu.upeu.biblioteca.repository.AccesoRepository;
import pe.edu.upeu.biblioteca.repository.RolRepository;

@Component
public class AccesoDaoImpl implements AccesoDao{
	@Autowired
	private AccesoRepository accesoRepository;
	
	@Autowired
	private RolRepository rolRepository;
	@Override
	public Acceso create(Acceso a) {
		// TODO Auto-generated method stub
		return accesoRepository.save(a);
	}

	@Override
	public Acceso update(Acceso a) {
		// TODO Auto-generated method stub
		return accesoRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		accesoRepository.deleteById(id);
	}

	@Override
	public Optional<Acceso> read(Long id) {
		// TODO Auto-generated method stub
		return accesoRepository.findById(id);
	}

	@Override
	public List<Acceso> readAll() {
		// TODO Auto-generated method stub
		return accesoRepository.findAll();
	}

	@Override
	public Acceso registrarAccesoRol(Long accesoId, Long rolId) {
		// TODO Auto-generated method stub
		Acceso ac = accesoRepository.findById(accesoId).get();
		Rol ro = rolRepository.findById(rolId).get();

		ac.getRols().add(ro);
		ro.getAccesos().add(ac);

		return accesoRepository.save(ac);
	}
	
}
