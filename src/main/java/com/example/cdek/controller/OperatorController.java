package com.example.cdek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cdek.model.OrderClient;
import com.example.cdek.repository.OrderReposImp;

@Controller
public class OperatorController {

	@Autowired
	private OrderReposImp orderReposImp;

	@GetMapping("operator")
	public String bidAll(Map<String, Object> model, @RequestParam(required = false, defaultValue = "") String id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Iterable<OrderClient> orderClient;
		boolean isBattonOne, isBattonTwo;
		if (id != null && !id.isEmpty()) {
			orderReposImp.changeStatus(auth.getName(), id);
			orderClient = orderReposImp.findAllStatus(auth.getName());
			isBattonOne = false;
			isBattonTwo = true;
			model.put("battonOne", isBattonOne);
			model.put("battonTwo", isBattonTwo);
			id = null;
		} else {
			isBattonOne = true;
			isBattonTwo = false;
			if (orderReposImp.findAllStatus(auth.getName()) != null
					&& !orderReposImp.findAllStatus(auth.getName()).isEmpty()) {
				orderClient = orderReposImp.findAllStatus(auth.getName());
				model.put("battonOne", isBattonOne);
				model.put("battonTwo", isBattonTwo);
			} else {
				orderClient = orderReposImp.findAllStatus("OPERATOR");
				model.put("battonOne", isBattonOne);
				model.put("battonTwo", isBattonTwo);
			}
		}
		model.put("orders", orderClient);
		return "operator";
	}

	@PostMapping("/searchBid")
	public String SearcBid(@RequestParam String searchBid, Map<String, Object> model) {

		Iterable<OrderClient> orderClient;
		boolean battonOne = true, battonTwo = false;
		if (searchBid != null && !searchBid.isEmpty()) {
			orderClient = orderReposImp.findOrder(searchBid);
		} else {
			orderClient = orderReposImp.findAllStatus("OPERATOR");
		}
		model.put("orders", orderClient);
		model.put("battonOne", battonOne);
		model.put("battonTwo", battonTwo);
		return "operator";
	}

	@GetMapping("/deletebid")
	public String deleteOrder(@RequestParam String idOrder) {
		orderReposImp.changeStatus("COURIER", idOrder);
		return "redirect:/operator";
	}

}
