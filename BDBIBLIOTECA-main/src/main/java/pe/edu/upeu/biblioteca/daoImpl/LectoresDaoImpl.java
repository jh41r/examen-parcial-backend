package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.LectoresDao;
import pe.edu.upeu.biblioteca.entity.Lectores;
import pe.edu.upeu.biblioteca.repository.LectoresRepository;

@Component
public class LectoresDaoImpl implements LectoresDao{
	@Autowired
	private LectoresRepository lectoresRepository;
	@Override
	public Lectores create(Lectores l) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(l);
	}

	@Override
	public Lectores update(Lectores l) {
		// TODO Auto-generated method stub
		return lectoresRepository.save(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		lectoresRepository.deleteById(id);
	}

	@Override
	public Optional<Lectores> read(Long id) {
		// TODO Auto-generated method stub
		return lectoresRepository.findById(id);
	}

	@Override
	public List<Lectores> readAll() {
		// TODO Auto-generated method stub
		return lectoresRepository.findAll();
	}

}
