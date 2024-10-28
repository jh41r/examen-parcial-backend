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
import pe.edu.upeu.biblioteca.entity.Empleados;
import pe.edu.upeu.biblioteca.entity.Libros;
import pe.edu.upeu.biblioteca.service.EmpleadosService;

@RestController
@RequestMapping("api/empleados")
public class EmpleadosController {
	@Autowired
	private EmpleadosService empleadosService;
	
	@GetMapping
	public ResponseEntity<List<Empleados>> readAll() {
		try {
			List<Empleados> e = empleadosService.readAll();
			if (e.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(e,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleados> read(@PathVariable("id") Long id) {
		try {
			Empleados e = empleadosService.read(id).get();
			return new ResponseEntity<>(e,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Empleados> create(@Valid @RequestBody Empleados emp) {
		try {
			Empleados e = empleadosService.create(emp);
			return new ResponseEntity<>(e,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empleados> update(@PathVariable("id") Long id, @Valid @RequestBody Empleados emp) {
		Optional<Empleados> e = empleadosService.read(id);
		if (e.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(empleadosService.update(emp),HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Libros> delete(@PathVariable("id") Long id) {
		try {
			empleadosService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
