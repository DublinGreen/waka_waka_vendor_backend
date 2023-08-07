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

import com.wakawakavendor.models.User;
import com.wakawakavendor.exceptions.ResourceNotFoundException;
import com.wakawakavendor.exceptions.UserNotFoundException;
import com.wakawakavendor.repositories.UserRepository;

/**
 * The type User controller. User api controller
 * 
 * @author idisimagha dublin-green
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Get all user list.
	 *
	 * @return the list
	 */
	@GetMapping("/get")
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	/**
	 * Gets user by id.
	 *
	 * @param id
	 * @return the user
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/create")
	public User create(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	// Update a Note
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails)
			throws UserNotFoundException {

		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

		user.setFirstName(userDetails.getFirstName());
		user.setMiddleName(userDetails.getMiddleName());
		user.setLastName(userDetails.getLastName());

		User updatedUser = userRepository.save(user);

		return updatedUser;
	}

	// Delete a Note
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

		userRepository.delete(user);

		return ResponseEntity.ok().build();
	}

}
