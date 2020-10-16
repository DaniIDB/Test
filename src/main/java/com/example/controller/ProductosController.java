package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProductosController {
	@Autowired
	ProductService productService;

	// http://localhost:8080/saveProduct?nombre=mesas&cantidad=12
	@GetMapping("/saveProduct")
	public String save(@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "cantidad", required = true) int cantidad) {
		String response = "Saved";
		try {
			productService.save(nombre, cantidad);
		} catch (Exception e) {
			log.info("Error saving the product {} {}", nombre, e.getMessage());
			response = "Error";
		}
		return response;
	}

	// http://localhost:8080/getProductByName?nombre=mesas
	@GetMapping("/getProductByName")
	public String getProductByName(@RequestParam(value = "nombre", required = true) String nombre) {
		String response = "";
		try {
			response = productService.getProductByName(nombre);
			if (response.equals("[]"))
				response = "is not found";
		} catch (JsonProcessingException ex) {
			response = "error";
			log.info("Error looking for product with name {} {}", nombre, ex.getMessage());
		}
		return response;
	}

	// http://localhost:8080/updateProductById?id=1&NuevoNombre=mesas&NuevaCantidad=13
	@GetMapping("/updateProductById")
	public String updateById(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "NuevoNombre", required = true) String nombre,
			@RequestParam(value = "NuevaCantidad", required = true) int cantidad) {
		String response = "Chages saved";
		try {
			if (productService.getProductById(id)) {
				response = "The product is not found";
			} else
				productService.updateById(id, nombre, cantidad);
		} catch (Exception e) {
			log.info("Error updating Product with id {}: {}", id, e.getMessage());
			response = "Error updating Product";
		}
		return response;
	}

}
