package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.Clientes;
import com.example.dto.Productos;
import com.example.repository.RepositoryClientes;
import com.example.repository.RepositoryProductos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	@Autowired
	private RepositoryProductos rest;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void save(String nombre, int cantidad) throws Exception {
		Productos product = new Productos(nombre, cantidad);
		rest.save(product);
	}
	
	public String getProductByName(String nombre) throws JsonProcessingException {

		List<Productos> list = new ArrayList<>();
		list = rest.findByNombre(nombre);
		return objectMapper.writeValueAsString(list);
	}
	
	public Boolean getProductId(int id) {

		List<Productos> list = new ArrayList<>();
		list = rest.findByIdProducto(id);
		return (list.isEmpty());
	}
	
	public String getProductByCantidad(int cantidad) throws JsonProcessingException{
		List<Productos> list = new ArrayList<>();
		list = rest.findByCantidad(cantidad);
		return objectMapper.writeValueAsString(list);
	}
	
	public void updateById(int id, String name, int cantidad) throws Exception{
		rest.updateProductById(id, name, cantidad);
	}
}
