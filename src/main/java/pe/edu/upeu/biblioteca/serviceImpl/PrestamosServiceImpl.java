package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.PrestamosDao;
import pe.edu.upeu.biblioteca.entity.Prestamos;
import pe.edu.upeu.biblioteca.service.PrestamosService;

@Service
public class PrestamosServiceImpl implements PrestamosService{
	@Autowired
	private PrestamosDao prestamosDao;
	@Override
	public Prestamos create(Prestamos p) {
		// TODO Auto-generated method stub
		return prestamosDao.create(p);
	}

	@Override
	public Prestamos update(Prestamos p) {
		// TODO Auto-generated method stub
		return prestamosDao.update(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		prestamosDao.delete(id);
	}

	@Override
	public Optional<Prestamos> read(Long id) {
		// TODO Auto-generated method stub
		return prestamosDao.read(id);
	}

	@Override
	public List<Prestamos> readAll() {
		// TODO Auto-generated method stub
		return prestamosDao.readAll();
	}

}
