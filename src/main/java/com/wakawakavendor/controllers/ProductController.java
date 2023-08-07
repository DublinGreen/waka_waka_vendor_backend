package com.wakawakavendor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wakawakavendor.exceptions.ResourceNotFoundException;
import com.wakawakavendor.models.Category;
import com.wakawakavendor.models.Product;
import com.wakawakavendor.repositories.CategoryRepository;
import com.wakawakavendor.repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping("/get")
	public List<Product> getAll() {
		return repository.findAll();

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Product> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + id));
		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/create")
	public Product create(@Valid @RequestBody Product product) {
		return repository.save(product);
	}

	@PutMapping("/update/{id}")
	public Product update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product details)
			throws ResourceNotFoundException {

		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + id));

		product.setCategoryId(details.getCategoryId());
		product.setDescription(details.getDescription());
		product.setImages(details.getImages());
		product.setName(details.getName());
		product.setPrice(details.getPrice());
		product.setStatus(details.getStatus());

		Product updateProduct = repository.save(product);

		return updateProduct;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + id));

		repository.delete(product);

		return ResponseEntity.ok().build();
	}

}
