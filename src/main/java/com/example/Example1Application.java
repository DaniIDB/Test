package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.dto.Clientes;
import com.example.dto.Productos;
import com.example.repository.RepositoryClientes;
import com.example.repository.RepositoryProductos;

@SpringBootApplication
@ComponentScan
public class Example1Application {
	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);

	}

	/*@PostConstruct
	public void loadData() {
		
	}*/
}
