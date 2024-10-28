package pe.edu.upeu.biblioteca.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "libros")
public class Libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "paginas")
	private int paginas;
	@Column(name = "edicion")
	private String edicion;
	@Column(name = "estado")
	private char estado;
	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = true)
	private Secciones secciones;
	@ManyToMany
	@JoinTable(
			name = "libro_autor",
			joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id")
			)
	private Set<Autores> autores = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "editorial_id", nullable = true)
	private Editoriales editoriales;
	@OneToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Detalle_Prestamo> detalle_Prestamos;

}
