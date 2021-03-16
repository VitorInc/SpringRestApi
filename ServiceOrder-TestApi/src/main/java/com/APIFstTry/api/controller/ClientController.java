package com.APIFstTry.api.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIFstTry.domain.model.Client;

@RestController
public class ClientController {
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Client> listar() {
		return manager.createQuery("from Client", Client.class)
				.getResultList();
	}

}
