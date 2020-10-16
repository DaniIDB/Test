package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Pedido;
import com.example.dto.Productos;

public interface RepositoryPedidos extends CrudRepository<Pedido, Integer>{
List<Productos> findByNombre(String nombre);
	
	List<Pedido> findByIdPedido(int idPedido);
	
	List<Pedido> findByIdProducto(int idProducto);
	
	List<Pedido> findByIdCliente(int idCliente);
	
	@Transactional
	@Modifying
	@Query("UPDATE Pedidos p SET p.idCliente = :idCliente, p.idProducto =:cantidad WHERE idPedidos= :idPedidos")
	void updatePedidoById( int idPedidos,  int idCliente, int idProducto);
}
