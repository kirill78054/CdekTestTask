package com.example.cdek.controller;

import java.util.Map;

import org.joda.time.LocalDateTime;
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
public class CourierController {
	
	@Autowired
	private OrderReposImp orderReposImp;
	
	@GetMapping("/courier")
	public String orderAll(Map<String, Object> model, @RequestParam(required = false, defaultValue = "") String id) {

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
				orderClient = orderReposImp.findAllStatus("COURIER");
				model.put("battonOne", isBattonOne);
				model.put("battonTwo", isBattonTwo);
			}
		}
		model.put("orders", orderClient);
		return "courier";
	}

	@PostMapping("courier")
	public String addOperator(Map<String, Object> model,
			@RequestParam(required = false, defaultValue = "") String idOperator) {
		String date = LocalDateTime.now().toString("MM/dd/yyyy HH:mm:ss");
		if (idOperator != null && !idOperator.isEmpty()) {
			orderReposImp.changeStatus("OPERATOR", idOperator);
			orderReposImp.changeDate(date, idOperator);
		}
		return "redirect:/courier";
	}

	@GetMapping("/deleteOrder")
	public String deleteOrder(@RequestParam int idOrder) {
		orderReposImp.delete(idOrder);
		return "redirect:/courier";
	}

}
