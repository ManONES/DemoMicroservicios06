package com.manycode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.manycode.app.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class SaludoController {

//    @Autowired
//    private RestTemplate restTemplate;
    
    @Autowired
    WebClient.Builder webClientBuilder;    

//    @RequestMapping("/Pase")
//    public String inicio() {
//        UserRating userRating = restTemplate.getForObject("http://DemoMicroservicios07/ratingsdata/user/MANY", UserRating.class);
//        return (userRating.getUserId());        
//    }


    @RequestMapping("/Pase")
    public String inicio() {
//    	UserRating userRating = webClientBuilder.build().get().uri("http://localhost:8080/user/MANY")
    	UserRating userRating = webClientBuilder.build().get().uri("http://aplimicroservcios12.demomicroservcios12.svc.cluster.local/user/MANY")
    			.retrieve().bodyToMono(UserRating.class).block();
    	return (userRating.getUserId());    	
    }
    
    
    @RequestMapping("/Pase2")
    public String iniciodos() {
//    	UserRating userRating = webClientBuilder.build().get().uri("http://localhost:8080/user2/MANY")
    	UserRating userRating = webClientBuilder.build().get().uri("http://aplimicroservcios12.demomicroservcios12.svc.cluster.local/user2/MANY")
    			.retrieve().bodyToMono(UserRating.class).block();
    	return (userRating.getUserId());    	
    }
    	
    
	@GetMapping("/TestOrigen")
	public String welcome() {
		return "Hola al mundo de Many  con  microservciios 04150205";
	}	
	
}