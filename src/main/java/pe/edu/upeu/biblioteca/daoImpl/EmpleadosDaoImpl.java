package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.EmpleadosDao;
import pe.edu.upeu.biblioteca.entity.Empleados;
import pe.edu.upeu.biblioteca.repository.EmpleadosRepository;

@Component
public class EmpleadosDaoImpl implements EmpleadosDao{
	@Autowired
	private EmpleadosRepository empleadosRepository;
	@Override
	public Empleados create(Empleados e) {
		// TODO Auto-generated method stub
		return empleadosRepository.save(e);
	}

	@Override
	public Empleados update(Empleados e) {
		// TODO Auto-generated method stub
		return empleadosRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadosRepository.deleteById(id);
	}

	@Override
	public Optional<Empleados> read(Long id) {
		// TODO Auto-generated method stub
		return empleadosRepository.findById(id);
	}

	@Override
	public List<Empleados> readAll() {
		// TODO Auto-generated method stub
		return empleadosRepository.findAll();
	}

}
