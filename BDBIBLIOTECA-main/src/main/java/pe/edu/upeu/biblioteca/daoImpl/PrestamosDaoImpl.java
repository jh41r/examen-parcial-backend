package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.PrestamosDao;
import pe.edu.upeu.biblioteca.entity.Prestamos;
import pe.edu.upeu.biblioteca.repository.PrestamosRepository;

@Component
public class PrestamosDaoImpl implements PrestamosDao{
	@Autowired
	private PrestamosRepository prestamosRepository;
	@Override
	public Prestamos create(Prestamos p) {
		// TODO Auto-generated method stub
		return prestamosRepository.save(p);
	}

	@Override
	public Prestamos update(Prestamos p) {
		// TODO Auto-generated method stub
		return prestamosRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		prestamosRepository.deleteById(id);
	}

	@Override
	public Optional<Prestamos> read(Long id) {
		// TODO Auto-generated method stub
		return prestamosRepository.findById(id);
	}

	@Override
	public List<Prestamos> readAll() {
		// TODO Auto-generated method stub
		return prestamosRepository.findAll();
	}

}
