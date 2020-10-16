package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Clientes;
import com.example.dto.Pedido;
import com.example.dto.Productos;
import com.example.repository.RepositoryClientes;
import com.example.repository.RepositoryPedidos;
import com.example.repository.RepositoryProductos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PedidoService {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RepositoryPedidos restPedidos;
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ObjectMapper objectMapper;

	public void save(int idCliente, int idProducto) throws Exception {
		Pedido pedido = new Pedido(idCliente, idProducto);
		restPedidos.save(pedido);
	}

	public String getPedidoById(int idPedido) throws JsonProcessingException {

		List<Pedido> list = new ArrayList<>();
		list = restPedidos.findByIdPedido(idPedido);
		return objectMapper.writeValueAsString(list);
	}

	public String getPedidotByClienteId(int idCliente) throws JsonProcessingException {

		List<Pedido> list = new ArrayList<>();
		list = restPedidos.findByIdCliente(idCliente);
		return objectMapper.writeValueAsString(list);
	}

	public String getPedidoByProductId(int idProducto) throws JsonProcessingException {
		List<Pedido> list = new ArrayList<>();
		list = restPedidos.findByIdProducto(idProducto);
		return objectMapper.writeValueAsString(list);
	}
	
	public Boolean getCustomerById(int idCustomer) {
		return clienteService.getCustomerById(idCustomer);
	}
	
	public Boolean getProductById(int idProduct) {
		return clienteService.getCustomerById(idProduct);
	}

	public void updatePedidoById(int idPedido, int idCliente, int idProducto) throws Exception {
		restPedidos.updatePedidoById(idPedido, idCliente, idProducto);
	}
}
