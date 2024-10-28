package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.Detalle_PrestamoDao;
import pe.edu.upeu.biblioteca.entity.Detalle_Prestamo;
import pe.edu.upeu.biblioteca.service.Detalle_PrestamoService;

@Service
public class Detalle_PrestamoServiceImpl implements Detalle_PrestamoService{
	@Autowired
	private Detalle_PrestamoDao detalle_PrestamoRepository;
	@Override
	public Detalle_Prestamo create(Detalle_Prestamo d) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.create(d);
	}

	@Override
	public Detalle_Prestamo update(Detalle_Prestamo d) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detalle_PrestamoRepository.delete(id);
	}

	@Override
	public Optional<Detalle_Prestamo> read(Long id) {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.read(id);
	}

	@Override
	public List<Detalle_Prestamo> readAll() {
		// TODO Auto-generated method stub
		return detalle_PrestamoRepository.readAll();
	}

}
