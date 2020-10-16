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
public interface RepositoryClientes extends CrudRepository<Clientes, Integer>{
	
	
	List<Clientes> findByNombre(String nombre);
	
	List<Clientes> findByApellidos(String apellidos);
	
	List<Clientes> findByidClientes(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Clientes c SET c.nombre = :nombre, c.apellidos =:apellidos WHERE idClientes= :idClientes")
	void updateCustomerById( int idClientes,  String nombre, String apellidos);

}
