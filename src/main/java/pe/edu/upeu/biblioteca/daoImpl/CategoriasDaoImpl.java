package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.CategoriasDao;
import pe.edu.upeu.biblioteca.entity.Categorias;
import pe.edu.upeu.biblioteca.repository.CategoriaRepository;

@Component
public class CategoriasDaoImpl implements CategoriasDao{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Override
	public Categorias create(Categorias c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public Categorias update(Categorias c) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<Categorias> read(Long id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id);
	}

	@Override
	public List<Categorias> readAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
