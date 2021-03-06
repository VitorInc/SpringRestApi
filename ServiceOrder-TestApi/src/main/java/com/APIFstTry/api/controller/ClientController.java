package com.APIFstTry.api.controller;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.APIFstTry.domain.model.Client;
import com.APIFstTry.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clientes")
	public List <Client> listar(){
		return clientRepository.findAll();
	}
	@GetMapping("/{clientId}")
	public ResponseEntity <Client> buscar(@PathVariable Long clientId) {
	Optional<Client> client  = clientRepository.findById(clientId);
	
	if(client.isPresent()) {
		return ResponseEntity.ok(client.get());
	}
	return ResponseEntity.notFound().build();
	}
	@PostMapping
	public Client adicionar(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	@PutMapping("{clientId}")
	public ResponseEntity<Client> atualizar(@PathVariable Long clientId,
		@RequestBody Client client ){
		
		if(clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(clientId);
		clientRepository.save(client);
		return ResponseEntity.ok(client);
	}
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> remover(Long clientId){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		clientRepository.deleteById(clientId);
		
		return ResponseEntity.noContent().build();
	}
}
