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
import com.wakawakavendor.models.Vendor;
import com.wakawakavendor.repositories.VendorRepository;

@RestController
@RequestMapping("/api/v1/vendor")
@CrossOrigin(origins = "http://localhost:8080")
public class VendorController {

	@Autowired
	private VendorRepository repository;

	@GetMapping("/get")
	public List<Vendor> getAll() {
		return repository.findAll();

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Vendor> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Vendor vendor = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor not found on :: " + id));
		return ResponseEntity.ok().body(vendor);
	}

	@PostMapping("/create")
	public Vendor create(@Valid @RequestBody Vendor vendor) {
		return repository.save(vendor);
	}

	@PutMapping("/update/{id}")
	public Vendor update(@PathVariable(value = "id") Long id, @Valid @RequestBody Vendor details)
			throws ResourceNotFoundException {

		Vendor vendor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found on :: " + id));

		vendor.setFirstName(details.getFirstName());
		vendor.setMiddleName(details.getMiddleName());
		vendor.setLastName(details.getLastName());

		Vendor updateVendor = repository.save(vendor);

		return updateVendor;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		Vendor vendor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found on :: " + id));

		repository.delete(vendor);

		return ResponseEntity.ok().build();
	}

}
