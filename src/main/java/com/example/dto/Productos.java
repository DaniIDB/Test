package com.example.dto;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Productos implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7927697821010307965L;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idproductos", unique = true, nullable = false)
	private int idProducto;
	private String nombre;
	private int cantidad;
	
	
	public Productos(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	
}
