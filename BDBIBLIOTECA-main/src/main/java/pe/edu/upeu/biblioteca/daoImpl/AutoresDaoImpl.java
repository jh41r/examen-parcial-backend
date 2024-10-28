package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.AutoresDao;
import pe.edu.upeu.biblioteca.entity.Autores;
import pe.edu.upeu.biblioteca.repository.AutoresRepository;

@Component
public class AutoresDaoImpl implements AutoresDao{
	@Autowired
	private AutoresRepository autoresRepository;
	@Override
	public Autores create(Autores a) {
		// TODO Auto-generated method stub
		return autoresRepository.save(a);
	}

	@Override
	public Autores update(Autores a) {
		// TODO Auto-generated method stub
		return autoresRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autoresRepository.deleteById(id);
	}

	@Override
	public Optional<Autores> read(Long id) {
		// TODO Auto-generated method stub
		return autoresRepository.findById(id);
	}

	@Override
	public List<Autores> readAll() {
		// TODO Auto-generated method stub
		return autoresRepository.findAll();
	}
	
}
