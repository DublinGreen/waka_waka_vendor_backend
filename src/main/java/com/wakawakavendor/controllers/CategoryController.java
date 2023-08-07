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
import com.wakawakavendor.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@GetMapping("/get")
	public List<Category> getAll() {
		return repository.findAll();

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Category> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Category category = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found on :: " + id));
		return ResponseEntity.ok().body(category);
	}

	@PostMapping("/create")
	public Category create(@Valid @RequestBody Category category) {
		return repository.save(category);
	}

	@PutMapping("/update/{id}")
	public Category update(@PathVariable(value = "id") Long id, @Valid @RequestBody Category details)
			throws ResourceNotFoundException {

		Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found on :: " + id));

		category.setDescription(details.getDescription());
		category.setName(details.getName());

		Category updateCategory = repository.save(category);

		return updateCategory;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found on :: " + id));

		repository.delete(category);

		return ResponseEntity.ok().build();
	}

}
