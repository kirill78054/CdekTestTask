package com.example.cdek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cdek.model.OrderClient;
import com.example.cdek.repository.OrderReposImp;
import com.example.cdek.repository.UserReposImpl;

import java.util.Map;

@Controller
public class MainController {
	@Autowired
	OrderReposImp orderReposImp;
	
	@Autowired
	UserReposImpl userReposImpl;
		
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {	  	
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getName() != null && !auth.getName().equals("anonymousUser")) {
        	String role = userReposImpl.findRoleUser(auth.getName());
        	if(role.equals("2")) {
        		return "redirect:/courier";
        	}
        	if(role.equals("3")) {
        		return "redirect:/operator";
        	}
    	}   	
    	Iterable<OrderClient> orderClient = orderReposImp.findAll();
        model.put("orders", orderClient);
        return "main";
    }
       
    @PostMapping("/main")
    public String add(@RequestParam String title, @RequestParam String address, Map<String, Object> model) {
    	OrderClient orderClients = new OrderClient(title, address);
    	orderReposImp.save(orderClients);
    	Iterable<OrderClient> orderClient = orderReposImp.findAll();
        model.put("orders", orderClient);
        return "main";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
    	orderReposImp.delete(id);
        return "redirect:/main";
    }   
    
    @PostMapping("search")
    public String Search(
    		@RequestParam String search, 
    		Map<String, OrderClient> model, 
    		Map<String, Object> modelOne) {
    	
    	Iterable<OrderClient> orderClient;
        if (search != null && !search.isEmpty()) {       	
        	orderClient = orderReposImp.findOrder(search);
        } else {
        	orderClient = orderReposImp.findAll();
        }
        modelOne.put("orders", orderClient);
        return "main";
    }
            
}