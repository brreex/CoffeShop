package edu.mum.coffee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ProductController {
	private  ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/ws/products",method=RequestMethod.GET)
	@ResponseBody
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
	
	@RequestMapping(value="/ws/product/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Product getProduct(@PathVariable int id){
		System.out.println(id);
		return productService.getProduct(id);
	}
	
	@RequestMapping(value="/ws/product",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product prod, Model model){
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("products");
		System.out.println(prod);
		productService.save(prod);
		model.addAttribute("message","Product Saved");
		return mnv;
	}
	
	@RequestMapping(value="/ws/product/{id}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id){
		Product prod = productService.getProduct(id);
		System.out.println(prod);
		if(prod!=null)
			productService.delete(productService.getProduct((int) id));
	}
	
	@RequestMapping(value="/ws/product/{id}",method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product,@PathVariable int id){
		Product prod = productService.getProduct(id);
		
		prod.setDescription(product.getDescription());
		prod.setPrice(product.getPrice());
		prod.setProductName(product.getProductName());
		prod.setProductType(product.getProductType());
		
		productService.save(prod);
	}
}
