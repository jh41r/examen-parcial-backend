package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.Detalle_PrestamoDao;
import pe.edu.upeu.biblioteca.entity.Detalle_Prestamo;
import pe.edu.upeu.biblioteca.repository.Detalle_PrestamoRepository;

@Component
public class Detalle_PrestamoDaoImpl implements Detalle_PrestamoDao{
	@Autowired
	private Detalle_PrestamoRepository detalle_PrestamoRepository;
	@Override
	public Detalle_Prestamo create(Detalle_Prestamo d) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.save(d);
	}

	@Override
	public Detalle_Prestamo update(Detalle_Prestamo d) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detalle_PrestamoRepository.deleteById(id);
	}

	@Override
	public Optional<Detalle_Prestamo> read(Long id) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.findById(id);
	}

	@Override
	public List<Detalle_Prestamo> readAll() {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.findAll();
	}
	
}
