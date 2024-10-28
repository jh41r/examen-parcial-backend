package pe.edu.upeu.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.biblioteca.entity.Lectores;
import pe.edu.upeu.biblioteca.service.LectoresService;

@RestController
@RequestMapping("api/lectores")
public class LectoresController {
	@Autowired
	private LectoresService lectoresService;
	
	@GetMapping
	public ResponseEntity<List<Lectores>> readAll() {
		try {
			List<Lectores> l = lectoresService.readAll();
			if (l.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(l, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Lectores> create(@Valid @RequestBody Lectores lec) {
		try {
			Lectores l = lectoresService.create(lec);
			return new ResponseEntity<>(l,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Lectores> read(@PathVariable("id") Long id) {
		try {
			Lectores l = lectoresService.read(id).get();
			return new ResponseEntity<>(l,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Lectores> delete(@PathVariable("id") Long id) {
		try {
			lectoresService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Lectores> update(@PathVariable("id") Long id, @Valid @RequestBody Lectores lec) {
		//TODO: process PUT request
		Optional<Lectores> l = lectoresService.read(id);
		if (l.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(lectoresService.update(lec),HttpStatus.CREATED);
		}
	}
}
