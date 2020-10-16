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
@Table(name = "clientes")
public class Clientes implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7927697821010307965L;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_clientes", unique = true, nullable = false)
	private int idClientes;
	private String nombre;
	private String apellidos;
	
	
	public Clientes(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
}

