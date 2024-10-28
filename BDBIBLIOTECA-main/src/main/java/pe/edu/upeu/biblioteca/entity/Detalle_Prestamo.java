package pe.edu.upeu.biblioteca.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detalle_prestamo")
public class Detalle_Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "fecha_entrega")
	private Date fecha_entrega; 	
	@Column(name = "estado")
	private char estado; 	
	@ManyToOne
	@JoinColumn(name = "libro_id", nullable = true)
	private Libros libros;
	@ManyToOne
	@JoinColumn(name = "prestamo_id", nullable = true)
	private Prestamos prestamos;
}
