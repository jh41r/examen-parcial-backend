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
import pe.edu.upeu.biblioteca.entity.Acceso;
import pe.edu.upeu.biblioteca.service.AccesoService;

@RestController
@RequestMapping("api/acceso")
public class AccesoController {
	@Autowired
	private AccesoService accesoService;
	
	@GetMapping
	public ResponseEntity<List<Acceso>> readAll() {
		try {
			List<Acceso> a = accesoService.readAll();
			if (a.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(a,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acceso> read(@PathVariable("id") Long id) {
		try {
			Acceso a = accesoService.read(id).get();
			return new ResponseEntity<>(a,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Acceso> create(@Valid @RequestBody Acceso acc) {
		try {
			Acceso a = accesoService.create(acc);
			return new ResponseEntity<>(a,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Acceso> update(@PathVariable("id") Long id, @Valid @RequestBody Acceso acc) {
		Optional<Acceso> a = accesoService.read(id);
		if (a.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(accesoService.update(acc),HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Acceso> delete(@PathVariable("id") Long id) {
		try {
			accesoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{accesoId}/rol/{rolId}")
	public ResponseEntity<Acceso> registroAccesoRol(@PathVariable Long accesoId, @PathVariable Long rolId){
		 Acceso acceso = accesoService.registrarAccesoRol(accesoId, rolId);
		 return ResponseEntity.ok(acceso);
		
	}
}
