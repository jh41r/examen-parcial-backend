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
import pe.edu.upeu.biblioteca.entity.Secciones;
import pe.edu.upeu.biblioteca.service.SeccionesService;

@RestController
@RequestMapping("/api/secciones")
public class SeccionesController {
	@Autowired
	private SeccionesService seccionesService;
	
	@GetMapping
	public ResponseEntity<List<Secciones>> readAll() {
		try {
			List<Secciones> s = seccionesService.readAll();
			if (s.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(s,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Secciones> read(@PathVariable("id") Long id) {
		try {
			Secciones secciones = seccionesService.read(id).get();
			return new ResponseEntity<>(secciones,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Secciones> create(@Valid @RequestBody Secciones sec) {
		try {
			Secciones secciones = seccionesService.create(sec);
			return new ResponseEntity<>(secciones,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Secciones> update(@PathVariable("id") Long id, @Valid @RequestBody Secciones sec) {
		Optional<Secciones> s = seccionesService.read(id);
		if (s.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(seccionesService.update(sec),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Secciones> delete(@PathVariable("id") Long id){
		try {
			seccionesService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
