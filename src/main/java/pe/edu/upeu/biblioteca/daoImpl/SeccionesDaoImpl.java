package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.SeccionesDao;
import pe.edu.upeu.biblioteca.entity.Secciones;
import pe.edu.upeu.biblioteca.repository.SeccionesRepository;

@Component
public class SeccionesDaoImpl implements SeccionesDao{
	@Autowired
	private SeccionesRepository seccionesRepository;
	@Override
	public Secciones create(Secciones s) {
		// TODO Auto-generated method stub
		return seccionesRepository.save(s);
	}

	@Override
	public Secciones update(Secciones s) {
		// TODO Auto-generated method stub
		return seccionesRepository.save(s);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		seccionesRepository.deleteById(id);
	}

	@Override
	public Optional<Secciones> read(Long id) {
		// TODO Auto-generated method stub
		return seccionesRepository.findById(id);
	}

	@Override
	public List<Secciones> readAll() {
		// TODO Auto-generated method stub
		return seccionesRepository.findAll();
	}

}
