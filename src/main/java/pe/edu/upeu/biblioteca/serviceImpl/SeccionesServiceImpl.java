package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.SeccionesDao;
import pe.edu.upeu.biblioteca.entity.Secciones;
import pe.edu.upeu.biblioteca.service.SeccionesService;

@Service
public class SeccionesServiceImpl implements SeccionesService{
	@Autowired
	private SeccionesDao seccionesDao;
	@Override
	public Secciones create(Secciones s) {
		// TODO Auto-generated method stub
		return seccionesDao.create(s);
	}

	@Override
	public Secciones update(Secciones s) {
		// TODO Auto-generated method stub
		return seccionesDao.update(s);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		seccionesDao.delete(id);
	}

	@Override
	public Optional<Secciones> read(Long id) {
		// TODO Auto-generated method stub
		return seccionesDao.read(id);
	}

	@Override
	public List<Secciones> readAll() {
		// TODO Auto-generated method stub
		return seccionesDao.readAll();
	}

}
