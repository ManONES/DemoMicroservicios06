package com.manycode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.manycode.app.model.UserRating;

@RestController
//@RequestMapping("/catalog")
public class SaludoController {

//    @Autowired
//    private RestTemplate restTemplate;
    
    @Autowired
    WebClient.Builder webClientBuilder;    
    
    @RequestMapping("/Pase1")
    public String iniciouno() {
    	//UserRating userRating = webClientBuilder.build().get().uri("http://demo-microservicios-7-git-hola.apps.us-west-1.starter.openshift-online.com/user/MANYTHREE")
    	UserRating userRating = webClientBuilder.build().get().uri("http://app0601-testpost01.apps.us-west-1.starter.openshift-online.com/user/MANYTHREE")
    			.retrieve().bodyToMono(UserRating.class).block();          
    	return (userRating.getUserId());    	
    }
    
    @RequestMapping("/PaseTest")
    public String iniciotres() {
    	UserRating userRating = webClientBuilder.build().get().uri("app6/user/MANYTHREE")
    			.retrieve().bodyToMono(UserRating.class).block();          
    	return (userRating.getUserId());    	
    }
    
    
	@GetMapping("/TestOrigen")
	public String welcome() {
		return "Hola al mundo de Many  con  microservciios 09122020";
	}	
	
}