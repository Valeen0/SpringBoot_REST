package com.init.products.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.init.products.DAO.ProductsDAO;
import com.init.products.entitys.Product;

// Spring le dice a esta clase que va a ser un servicio REST.
@RestController

//en que url se van a exponer los métodos de esta clase (servicios).
@RequestMapping("/products")
public class ProductsREST {
	
	// Spring genera un proxy (una clase que implementa la interfaz) y la inyecta
	@Autowired
	private ProductsDAO productDAO;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> products = productDAO.findAll();
		
		return ResponseEntity.ok(products);
		
	}
	
	@RequestMapping(value="{productId}") // ==> /products/{productId}  --> /products/1
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
		
		Optional<Product> optionalProduct = productDAO.findById(productId);
		
		
		return optionalProduct.isPresent() ? 
				ResponseEntity.ok(optionalProduct.get()) :
				ResponseEntity.noContent().build(); 
		

	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		Product newProduct = productDAO.save(product);
		
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value="{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){
		Product productDeleted = getProductById(productId).getBody();
		productDAO.deleteById(productId);
		
		return ResponseEntity.ok(productDeleted);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Optional<Product> optionalProduct = productDAO.findById(product.getId());
		
		
		if(optionalProduct.isPresent()) {
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}else {
			return ResponseEntity.noContent().build(); 
		}
				
	}
	
	
	// Este servicio va a estar disponible mediante el método GET.
	// @GetMapping
	// @RequestMapping(value="hello", method = RequestMethod.GET)
	// Ambos dan el mismo resultado, Diferencia: GetMapping no define una url. Toma como url la base (/)
	
	public String saludar() {
		
		return "Hola Mundo!";
		
	}
	
}
