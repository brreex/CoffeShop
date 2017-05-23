package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;

@RestController
public class OrderController {
	
	OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value="/ws/order",method=RequestMethod.POST)
	public void createOrder(@RequestBody Order order){
		orderService.save(order);
	}
	
	@RequestMapping(value="/ws/orders",method=RequestMethod.GET)
	public List<Order> findByProduct(@RequestBody Product product){
		return orderService.findByProduct(product);
	}
	
	/*@RequestMapping(value="/ws/orders",method=RequestMethod.GET)
	public List<Order> findByPerson(@RequestBody Person person){
		return orderService.findByPerson(person);
	}*/
	
	
	/*@RequestMapping(value="/ws/orders",method=RequestMethod.GET)
	public List<Order> getAllOrders(){
		return orderService.findAll();
	}
	*/
	
	@RequestMapping(value="/ws/order/{id}",method=RequestMethod.GET)
	public Order getOrder(@RequestParam int id){
		return orderService.findById(id);
	}
	
	
	/*@RequestMapping(value="/ws/order/{id}",method=RequestMethod.DELETE)
	public void deleteOrder(@RequestBody Order order){
		orderService.delete(order);
	}*/
	
}
