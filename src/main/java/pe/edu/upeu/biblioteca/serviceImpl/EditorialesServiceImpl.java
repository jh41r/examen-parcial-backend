package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.EditorialesDao;
import pe.edu.upeu.biblioteca.entity.Editoriales;
import pe.edu.upeu.biblioteca.service.EditorialesService;

@Service
public class EditorialesServiceImpl implements EditorialesService{
	@Autowired
	private EditorialesDao editorialesDao;
	@Override
	public Editoriales create(Editoriales e) {
		// TODO Auto-generated method stub
		return editorialesDao.create(e);
	}

	@Override
	public Editoriales update(Editoriales e) {
		// TODO Auto-generated method stub
		return editorialesDao.update(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialesDao.delete(id);
	}

	@Override
	public Optional<Editoriales> read(Long id) {
		// TODO Auto-generated method stub
		return editorialesDao.read(id);
	}

	@Override
	public List<Editoriales> readAll() {
		// TODO Auto-generated method stub
		return editorialesDao.readAll();
	}
	
}
