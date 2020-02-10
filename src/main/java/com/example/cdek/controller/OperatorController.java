package com.example.cdek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cdek.model.OrderClient;
import com.example.cdek.repository.OrderReposImp;

@Controller
public class OperatorController {
	
	@Autowired
	OrderReposImp orderReposImp;
		
	@GetMapping("/operator")
    public String bidAll(Map<String, Object> model, 
    		@RequestParam(required = false, defaultValue = "") String id) {	
		Iterable<OrderClient> orderClient;
		boolean battonOne, battonTwo;
		if(id != null &&  !id.isEmpty()) {
			orderReposImp.changeStatus(id, id);
	    	orderClient = orderReposImp.findAllStatus(id);
	    	battonOne = false;
	    	battonTwo = true;
	    	model.put("battonOne", battonOne);
	    	model.put("battonTwo", battonTwo);
		}else {
			battonOne = true;
			battonTwo = false;
			orderClient = orderReposImp.findAllStatus("OPERATOR");
			model.put("battonOne",battonOne);
			model.put("battonTwo", battonTwo);
		}
		
        model.put("orders", orderClient);
        return "operator";
    }
	
	@PostMapping("searchBid")
    public String SearcBid(
    		@RequestParam String searchBid, 
    		Map<String, OrderClient> model, 
    		Map<String, Object> modelOne) {
		
    	Iterable<OrderClient> orderClient = null;
    	OrderClient order = null;
    	
        if (searchBid != null && !searchBid.isEmpty()) {       	
        	order = orderReposImp.findOne(searchBid);
        	model.put("orders", order);
        } else {
        	orderClient = orderReposImp.findAllStatus("OPERATOR");
        	modelOne.put("orders", orderClient);
        }
        return "operator";
    }
	
	@GetMapping("/deletebid")
    public String deleteOrder(@RequestParam String idOrder) {
		orderReposImp.changeStatus("COURIER", idOrder);
        return "redirect:/operator";
    } 
	
	
	
}
