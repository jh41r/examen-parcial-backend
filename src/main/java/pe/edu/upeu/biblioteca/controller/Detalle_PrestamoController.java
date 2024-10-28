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
import pe.edu.upeu.biblioteca.entity.Detalle_Prestamo;
import pe.edu.upeu.biblioteca.service.Detalle_PrestamoService;

@RestController
@RequestMapping("api/detalle")
public class Detalle_PrestamoController {
	@Autowired
	private Detalle_PrestamoService detalle_PrestamoService;
	
	@GetMapping
	public ResponseEntity<List<Detalle_Prestamo>> readAll() {
		try {
			List<Detalle_Prestamo> d = detalle_PrestamoService.readAll();
			if (d.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(d,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Detalle_Prestamo> read(@PathVariable("id") Long id) {
		try {
			Detalle_Prestamo d = detalle_PrestamoService.read(id).get();
			return new ResponseEntity<>(d,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Detalle_Prestamo> create(@Valid @RequestBody Detalle_Prestamo dp) {
		try {
			Detalle_Prestamo d = detalle_PrestamoService.create(dp);
			return new ResponseEntity<>(d,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Detalle_Prestamo> delete(@PathVariable("id") Long id) {
		try {
			detalle_PrestamoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Detalle_Prestamo> update(@PathVariable("id") Long id, @Valid @RequestBody Detalle_Prestamo dt) {
		Optional<Detalle_Prestamo> d = detalle_PrestamoService.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(detalle_PrestamoService.update(dt),HttpStatus.CREATED);
		}
	}
}
