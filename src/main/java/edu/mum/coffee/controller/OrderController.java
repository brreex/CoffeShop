package edu.mum.coffee.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@RestController
public class OrderController {

	OrderService orderService;
	PersonService personService;
	ProductService productService;

	@Autowired
	public OrderController(OrderService orderService, PersonService personService, ProductService productService) {
		this.orderService = orderService;
		this.personService = personService;
		this.productService = productService;
	}

	@RequestMapping(value = "/ws/order/{id}", method = RequestMethod.POST)
	public void createOrder(@PathVariable int id, @RequestParam int quantity, Principal principal) {

		Order order = new Order();
		Person person = personService.getByEmail(principal.getName());

		order.setPerson(person);
		Orderline orderline = new Orderline();

		orderline.setOrder(order);
		order.setOrderDate(new Date());
		orderline.setProduct(productService.getProduct(id));
		orderline.setQuantity(quantity);

		order.addOrderLine(orderline);
		orderService.save(order);
	}

	@RequestMapping(value = "/ws/orders", method = RequestMethod.GET)
	public List<Order> findByProduct(@RequestBody Product product) {
		return orderService.findByProduct(product);
	}

	@RequestMapping(value = "/ws/order/{id}", method = RequestMethod.GET)
	public Order getOrder(@RequestParam int id) {
		return orderService.findById(id);
	}

	@RequestMapping(value = "/ws/order/{id}", method = RequestMethod.DELETE)
	public void deleteOrder(@RequestBody Order order) {
		orderService.delete(order);
	}

}
