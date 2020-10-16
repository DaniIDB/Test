package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.Clientes;
import com.example.dto.Productos;
import com.example.repository.RepositoryClientes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClienteService {

	@Autowired
	private RepositoryClientes rest;
	
	@Autowired
	private ObjectMapper objectMapper;

	// http://localhost:/save?
	public void save(String nombre, String apellido) throws Exception {
		
		Clientes customer = new Clientes(nombre, apellido);
		rest.save(customer);
	}

	public String getCustomerByName(String nombre) throws JsonProcessingException {

		List<Clientes> list = new ArrayList<>();

		list = rest.findByNombre(nombre);

		return objectMapper.writeValueAsString(list);
		
//		asdasda
//		adsasdadasddddddd
//		fgjk r wer wetrjñag kjadf 
//		ad ad a asdsaghj tkytuit
//		asdasda
//		adsasdadasddddddd
//		fgjk r wer wetrjñag kjadf 
//		ad ad a asdsaghj tkytuit
//		asdasda
//		adsasdadasddddddd
//		fgjk r wer wetrjñag kjadf 
//		ad ad a asdsaghj tkytuit
	}
	
	public Boolean getCustomerById(int id) {

		List<Clientes> list = new ArrayList<>();
		list = rest.findByidClientes(id);
		return (list.isEmpty());
	}

	public String getCustomerBySurname(String apellidos) throws JsonProcessingException{
		List<Clientes> list = new ArrayList<>();
		//Pedir al repositorio una petición
		rest.findByApellidos(apellidos);
		//Cambia Lista a String para poder enviar el parámetro a otros lenguajes que no tengan el tipo lista
		return objectMapper.writeValueAsString(list);
	}

	public void updateById(int id, String name, String surname) throws Exception{
		rest.updateCustomerById(id, name, surname);
	}
}
