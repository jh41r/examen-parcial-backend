package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.upeu.biblioteca.dao.LibrosDao;
import pe.edu.upeu.biblioteca.entity.Libros;
import pe.edu.upeu.biblioteca.service.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService{
	@Autowired
	private LibrosDao librosDao;
	@Override
	public Libros create(Libros l) {
		// TODO Auto-generated method stub
		return librosDao.create(l);
	}

	@Override
	public Libros update(Libros l) {
		// TODO Auto-generated method stub
		return librosDao.update(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		librosDao.delete(id);
	}

	@Override
	public Optional<Libros> read(Long id) {
		// TODO Auto-generated method stub
		return librosDao.read(id);
	}

	@Override
	public List<Libros> readAll() {
		// TODO Auto-generated method stub
		return librosDao.readAll();
	}

	@Override
	@Transactional
	public Libros createLibroAutor(Long libroId, Long autorId) {
		// TODO Auto-generated method stub
		return librosDao.registrarLibroAutor(libroId, autorId);
	}

}
