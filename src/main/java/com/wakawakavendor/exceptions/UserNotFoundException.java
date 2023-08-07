package com.wakawakavendor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author idisimagha dublin-green
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Role not found exception.
   *
   * @param message the message
   */
	public UserNotFoundException(Long id) {
		super("User with id : " + id + " was not found");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}

