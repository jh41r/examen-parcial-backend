package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.LibrosDao;
import pe.edu.upeu.biblioteca.entity.Autores;
import pe.edu.upeu.biblioteca.entity.Libros;
import pe.edu.upeu.biblioteca.repository.AutoresRepository;
import pe.edu.upeu.biblioteca.repository.LibrosRepository;

@Component
public class LibrosDaoImpl implements LibrosDao {
	@Autowired
	private LibrosRepository librosRepository;

	@Autowired
	private AutoresRepository autoresRepository;

	@Override
	public Libros create(Libros l) {
		// TODO Auto-generated method stub
		return librosRepository.save(l);
	}

	@Override
	public Libros update(Libros l) {
		// TODO Auto-generated method stub
		return librosRepository.save(l);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		librosRepository.deleteById(id);
	}

	@Override
	public Optional<Libros> read(Long id) {
		// TODO Auto-generated method stub
		return librosRepository.findById(id);
	}

	@Override
	public List<Libros> readAll() {
		// TODO Auto-generated method stub
		return librosRepository.findAll();
	}

	@Override
	public Libros registrarLibroAutor(Long libroId, Long autorId) {
		// TODO Auto-generated method stub

		Libros li = librosRepository.findById(libroId).get();
		Autores au = autoresRepository.findById(autorId).get();

		li.getAutores().add(au);
		au.getLibros().add(li);

		return librosRepository.save(li);
	}
}
