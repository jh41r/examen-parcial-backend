package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.AutoresDao;
import pe.edu.upeu.biblioteca.entity.Autores;
import pe.edu.upeu.biblioteca.service.AutoresService;
@Service
public class AutoresServiceImpl implements AutoresService{
	@Autowired
	private AutoresDao autoresDao;
	@Override
	public Autores create(Autores a) {
		// TODO Auto-generated method stub
		return autoresDao.create(a);
	}

	@Override
	public Autores update(Autores a) {
		// TODO Auto-generated method stub
		return autoresDao.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autoresDao.delete(id);
	}

	@Override
	public Optional<Autores> read(Long id) {
		// TODO Auto-generated method stub
		return autoresDao.read(id);
	}

	@Override
	public List<Autores> readAll() {
		// TODO Auto-generated method stub
		return autoresDao.readAll();
	}

}
