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
import pe.edu.upeu.biblioteca.entity.Libros;
import pe.edu.upeu.biblioteca.service.LibrosService;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {
	
	@Autowired
	private LibrosService librosService;
	
	@GetMapping
	public ResponseEntity<List<Libros>> readAll() {
		try {
			List<Libros> l = librosService.readAll();
			if (l.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(l,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Libros> read(@PathVariable("id") Long id) {
		try {
			Libros l = librosService.read(id).get();
			return new ResponseEntity<>(l,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Libros> create(@Valid @RequestBody Libros lib) {
		try {
			Libros l = librosService.create(lib);
			return new ResponseEntity<>(l,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Libros> update(@PathVariable("id") Long id, @Valid @RequestBody Libros lib) {
		Optional<Libros> l = librosService.read(id);
		if (l.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(librosService.update(lib),HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Libros> delete(@PathVariable("id") Long id) {
		try {
			librosService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{libroId}/autores/{autorId}")
	public ResponseEntity<Libros> registroLibroAutor(@PathVariable Long libroId, @PathVariable Long autorId){
		 Libros libro = librosService.createLibroAutor(libroId, autorId);
		 return ResponseEntity.ok(libro);
		
	}

}
