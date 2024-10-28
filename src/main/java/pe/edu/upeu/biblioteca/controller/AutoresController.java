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
import pe.edu.upeu.biblioteca.entity.Autores;
import pe.edu.upeu.biblioteca.service.AutoresService;

@RestController
@RequestMapping("/api/autores")
public class AutoresController {
	@Autowired
	private AutoresService autoresService;
	
	@GetMapping
	public ResponseEntity<List<Autores>> readAll(){
		try {
			List<Autores> a = autoresService.readAll();
			if (a.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(a,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Autores> read(@PathVariable("id") Long id) {
		try {
			Autores a = autoresService.read(id).get();
			return new ResponseEntity<>(a,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Autores> create(@Valid @RequestBody Autores aut) {
		try {
			Autores a = autoresService.create(aut);
			return new ResponseEntity<>(a,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Autores> delete(@PathVariable("id") Long id) {
		try {
			autoresService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Autores> update(@PathVariable("id") Long id, @Valid @RequestBody Autores aut) {
		Optional<Autores> a = autoresService.read(id);
		if (a.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(autoresService.create(aut), HttpStatus.CREATED);
		}
	}
}
