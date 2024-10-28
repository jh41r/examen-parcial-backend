package pe.edu.upeu.biblioteca.entity;

import java.sql.Date;
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
@Table(name = "prestamos")
public class Prestamos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "fecha_prestamo")
	private Date fecha_prestamo;
	@Column(name = "fecha_entrega")
	private Date fecha_entrega;
	@Column(name = "estado")
	private char estado;
	@OneToMany(mappedBy = "prestamos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Detalle_Prestamo> detalle_Prestamos;
	@ManyToOne
	@JoinColumn(name = "lector_id", nullable = true)
	private Lectores lectores;
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuarios usuarios;
}
