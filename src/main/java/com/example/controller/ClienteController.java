package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// http://localhost:/save?nombre=dani&apellido=jimenez
	@GetMapping("/save")
	public String save(@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "apellido", required = true) String apellido) {

		String response = "Saved";

		try {
			clienteService.save(nombre, apellido);
		} catch (Exception e) {
			log.error("Error saving {} {} : {}", nombre, apellido, e.getMessage());
			response = "ERROR";
		}

		return response;

	}

	// http://localhost:8080/getCustomerByName?nombre=dani
	@GetMapping("/getCustomerByName")
	public String getCustomerByName(@RequestParam(value = "nombre", required = true) String nombre) {

		String response = "";

		try {
			response = clienteService.getCustomerByName(nombre);
			if(response.equals("[]")) 
				response="is not found";
		} catch (JsonProcessingException e) {
			log.info("Error searching {}: {}", nombre, e.getMessage());
			response="ERROR";
		}

		return response;
	}

	// http://localhost:8080/getCustomerByApellidos?apellido=Gonzalez
 	@GetMapping("/getCustomerByApellidos")
	public String getCustomerBySurname(@RequestParam(value = "apellidos", required = true) String apellidos) {
 		
 		String response="";
 		
 		try {
 			response=clienteService.getCustomerBySurname(apellidos);
 			if(response.equals("[]")) 
				response="is not found";
 		}catch (JsonProcessingException ex) {
 			log.info("Error searching {}: {}", apellidos, ex.getMessage());
 			response="ERROR";
		}
		return response;
	}
	
 // http://localhost:8080/updateById?id=1&NuevoNombre=Ana&NuevoApellido=Jimenez
	@GetMapping("/updateById")
	public String updateById(@RequestParam(value = "id", required = true) int id,@RequestParam(value = "NuevoNombre", required = true) String nombre,
			@RequestParam(value = "NuevoApellido", required = true) String apellido) {
		String response="Chages saved";
		try {
			if(clienteService.getCustomerById(id)) {
				response="The product is not found";
			} else
				clienteService.updateById(id, nombre, apellido);
		}catch (Exception e) {
			log.info("Error updating customer with id {}: {}", id, e.getMessage());
			response="Error al actualizar el cliente";
		}
		return response;
	}

}
