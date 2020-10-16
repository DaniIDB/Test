package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.PedidoService;
import com.example.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PedidosController {
	@Autowired
	PedidoService pedidoService;

	// http://localhost:8080/savePedido?idCliente=1&idProducto=1
	@GetMapping("/savePedido")
	public String save(@RequestParam(value = "idCliente", required = true) int idCliente,
			@RequestParam(value = "idProducto", required = true) int idProducto) {
		String response = "Saved";
		try {
			if(pedidoService.getProductById(idProducto)&&pedidoService.getCustomerById(idCliente))
				response="Error looking for the product or customer id";
			else
			pedidoService.save(idCliente, idProducto);
		} catch (Exception e) {
			log.info("Error saving the order {} {}", e.getMessage());
			response = "Error";
		}
		return response;
	}

	// http://localhost:8080/getProductByName?nombre=mesas
	@GetMapping("/getOrderByIdCustomer")
	public String getPedidoByIdCustomer(@RequestParam(value = "idCliente", required = true) int idCliente) {
		String response = "";
		try {
			response = pedidoService.getPedidotByClienteId(idCliente);
			if (response.equals("[]"))
				response = "is not found";
		} catch (JsonProcessingException ex) {
			response = "error";
			log.info("Error looking for order with customer id {} {}", idCliente, ex.getMessage());
		}
		return response;
	}
	
	@GetMapping("/getOrderByIdProduct")
	public String getOrderByIdProduct(@RequestParam(value = "idProducto", required = true) int idProducto) {
		String response = "";
		try {
			response = pedidoService.getPedidoByProductId(idProducto);
			if (response.equals("[]"))
				response = "is not found";
		} catch (JsonProcessingException ex) {
			response = "error";
			log.info("Error looking for order with product id {} {}",idProducto, ex.getMessage());
		}
		return response;
	}
	
	@GetMapping("/getOrderByIdProduct")
	public String getOrderByIdOrder(@RequestParam(value = "idPedido", required = true) int idPedido) {
		String response = "";
		try {
			response = pedidoService.getPedidoById(idPedido);
			if (response.equals("[]"))
				response = "is not found";
		} catch (JsonProcessingException ex) {
			response = "error";
			log.info("Error looking for order with order id {} {}",idPedido, ex.getMessage());
		}
		return response;
	}

	// http://localhost:8080/updateProductById?id=1&NuevoNombre=mesas&NuevaCantidad=13
	@GetMapping("/updateOrderById")
	public String updateById(@RequestParam(value = "idPedido", required = true) int idPedido,
			@RequestParam(value = "clienteId", required = true) int clienteId,
			@RequestParam(value = "productoId", required = true) int productoId) {
		String response = "Chages saved";
		try {
			if(pedidoService.getProductById(productoId)&&pedidoService.getCustomerById(clienteId))
				response="Error looking for the product or customer id";
			else
				pedidoService.updatePedidoById(idPedido, clienteId, productoId);
		} catch (Exception e) {
			log.info("Error updating Product with id {}: {}", idPedido, e.getMessage());
			response = "Error updating Product";
		}
		return response;
	}

}
