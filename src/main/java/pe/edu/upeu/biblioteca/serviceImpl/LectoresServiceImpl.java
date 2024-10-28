package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.LectoresDao;
import pe.edu.upeu.biblioteca.entity.Lectores;
import pe.edu.upeu.biblioteca.service.LectoresService;

@Service
public class LectoresServiceImpl implements LectoresService{
	@Autowired
	private LectoresDao lectoresDao;
	@Override
	public Lectores create(Lectores l) {
		// TODO Auto-generated method stub
		return lectoresDao.create(l);
	}

	@Override
	public Lectores update(Lectores l) {
		// TODO Auto-generated method stub
		return lectoresDao.update(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lectoresDao.delete(id);
	}

	@Override
	public Optional<Lectores> read(Long id) {
		// TODO Auto-generated method stub
		return lectoresDao.read(id);
	}

	@Override
	public List<Lectores> readAll() {
		// TODO Auto-generated method stub
		return lectoresDao.readAll();
	}

}
