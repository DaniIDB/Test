package com.example.dto;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

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
@Table(name = "pedido")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = -6785856460280420341L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPedidos", unique = true, nullable = false)
	private int idPedido;
	private int idCliente;
	private int idProducto;
	
	
	public Pedido(int idCliente, int idProducto) {
		this.idCliente=idCliente;
		this.idProducto=idProducto;
	}
}
