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
import pe.edu.upeu.biblioteca.entity.Prestamos;
import pe.edu.upeu.biblioteca.service.PrestamosService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamosController {
	@Autowired
	private PrestamosService prestamosService;
	
	@GetMapping
	public ResponseEntity<List<Prestamos>> readAll() {
		try {
			List<Prestamos> p = prestamosService.readAll();
			if (p.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(p, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Prestamos> create(@Valid @RequestBody Prestamos pre) {
		try {
			Prestamos p = prestamosService.create(pre);
			return new ResponseEntity<>(p,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Prestamos> read(@PathVariable("id") Long id) {
		try {
			Prestamos p = prestamosService.read(id).get();
			return new ResponseEntity<>(p,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Prestamos> delete(@PathVariable("id") Long id) {
		try {
			prestamosService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prestamos> update(@PathVariable("id") Long id, @Valid @RequestBody Prestamos pre) {
		//TODO: process PUT request
		Optional<Prestamos> p = prestamosService.read(id);
		if (p.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(prestamosService.update(pre),HttpStatus.OK);
		}
	}
}
