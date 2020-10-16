package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Clientes;
import com.example.dto.Productos;

@Repository
public interface RepositoryProductos extends CrudRepository<Productos, Integer>{
	
	
	List<Productos> findByNombre(String nombre);
	
	List<Productos> findByCantidad(int cantidad);
	
	List<Productos> findByIdProducto(int id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE Productos p SET p.nombre = :nombre, p.cantidad =:cantidad WHERE idproductos= :idproductos",nativeQuery = true)
	void updateProductById( int idproductos,  String nombre, int cantidad);
	
}
