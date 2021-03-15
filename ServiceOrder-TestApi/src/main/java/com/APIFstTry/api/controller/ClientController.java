package com.APIFstTry.api.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIFstTry.domain.model.Clients;




@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Clients> listar() {
		var cliente1 = new Clients();
		cliente1.setId(1l);
		cliente1.setName("João");
		cliente1.setEmail("Joao@email");
		cliente1.setTelephone("+55 (11) 9 9874-1234");
		
		
		var cliente2 = new Clients();
		cliente2.setId(2l);
		cliente2.setName("Ana");
		cliente2.setEmail("ana@email");
		cliente2.setTelephone("+55 (11) 9 1234-9874");
		
		return Arrays.asList(cliente1,cliente2);
	}

}
