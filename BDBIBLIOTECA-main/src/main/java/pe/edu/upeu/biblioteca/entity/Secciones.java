package pe.edu.upeu.biblioteca.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "secciones")
public class Secciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "seccion")
	private String seccion;
	@Column(name = "estado")
	private char estado;
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = true)
	private Categorias categorias;
	@OneToMany(mappedBy = "secciones", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private	List<Libros> libros;
}
