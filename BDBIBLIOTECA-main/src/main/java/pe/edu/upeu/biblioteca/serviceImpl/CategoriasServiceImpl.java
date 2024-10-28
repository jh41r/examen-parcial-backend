package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.CategoriasDao;
import pe.edu.upeu.biblioteca.entity.Categorias;
import pe.edu.upeu.biblioteca.service.CategoriasService;
@Service
public class CategoriasServiceImpl implements CategoriasService{
	@Autowired
	private CategoriasDao categoriasDao;
	@Override
	public Categorias create(Categorias c) {
		// TODO Auto-generated method stub
		return categoriasDao.create(c);
	}

	@Override
	public Categorias update(Categorias c) {
		// TODO Auto-generated method stub
		return categoriasDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriasDao.delete(id);
	}

	@Override
	public Optional<Categorias> read(Long id) {
		// TODO Auto-generated method stub
		return categoriasDao.read(id);
	}

	@Override
	public List<Categorias> readAll() {
		// TODO Auto-generated method stub
		return categoriasDao.readAll();
	}

}
