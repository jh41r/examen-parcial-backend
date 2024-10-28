package pe.edu.upeu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.biblioteca.entity.Acceso;

@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long>{

}
