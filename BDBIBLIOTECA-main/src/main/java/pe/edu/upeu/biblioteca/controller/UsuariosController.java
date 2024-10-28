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
import pe.edu.upeu.biblioteca.entity.Usuarios;
import pe.edu.upeu.biblioteca.service.UsuariosService;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosService usuariosService;
	@GetMapping
	public ResponseEntity<List<Usuarios>> readAll() {
		try {
			List<Usuarios> u = usuariosService.readAll();
			if (u.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(u, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> create(@Valid @RequestBody Usuarios usu) {
		try {
			Usuarios u = usuariosService.create(usu);
			return new ResponseEntity<>(u,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> read(@PathVariable("id") Long id) {
		try {
			Usuarios u = usuariosService.read(id).get();
			return new ResponseEntity<>(u,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios> delete(@PathVariable("id") Long id) {
		try {
			usuariosService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> update(@PathVariable("id") Long id, @Valid @RequestBody Usuarios usu) {
		//TODO: process PUT request
		Optional<Usuarios> u = usuariosService.read(id);
		if (u.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(usuariosService.update(usu),HttpStatus.OK);
		}
	}
	
	@PostMapping("/{usuarioId}/rol/{rolId}")
	public ResponseEntity<Usuarios> registroUsuarioRol(@PathVariable Long usuarioId, @PathVariable Long rolId){
		 Usuarios usuarios = usuariosService.createUsuarioRol(usuarioId, rolId);
		 return ResponseEntity.ok(usuarios);
		
	}
}
