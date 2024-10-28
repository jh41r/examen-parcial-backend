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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.biblioteca.entity.Categorias;
import pe.edu.upeu.biblioteca.service.CategoriasService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {
	@Autowired
	private CategoriasService categoriasService;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> readAll() {
		try {
			List<Categorias> categorias = categoriasService.readAll();
			if (categorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Categorias> createCategoria(@Valid @RequestBody Categorias cat) {
		try {
			Categorias c = categoriasService.create(cat);
			return new ResponseEntity<>(c,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> read(@PathVariable("id") Long id) {
		try {
			Categorias c = categoriasService.read(id).get();
			return new ResponseEntity<>(c,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Categorias> delete(@PathVariable("id") Long id) {
		try {
			categoriasService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categorias> update(@PathVariable("id") Long id, @Valid @RequestBody Categorias cat) {
		//TODO: process PUT request
		Optional<Categorias> c = categoriasService.read(id);
		if (c.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(categoriasService.update(cat),HttpStatus.OK);
		}
	}
}
