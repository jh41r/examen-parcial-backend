package pe.edu.upeu.biblioteca.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.biblioteca.dao.EditorialesDao;
import pe.edu.upeu.biblioteca.entity.Editoriales;
import pe.edu.upeu.biblioteca.repository.EditorialesRepository;

@Component
public class EditorialesDaoImpl implements EditorialesDao{
	@Autowired
	private EditorialesRepository editorialesRepository;
	@Override
	public Editoriales create(Editoriales e) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(e);
	}

	@Override
	public Editoriales update(Editoriales e) {
		// TODO Auto-generated method stub
		return editorialesRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialesRepository.deleteById(id);
	}

	@Override
	public Optional<Editoriales> read(Long id) {
		// TODO Auto-generated method stub
		return editorialesRepository.findById(id);
	}

	@Override
	public List<Editoriales> readAll() {
		// TODO Auto-generated method stub
		return editorialesRepository.findAll();
	}

}
