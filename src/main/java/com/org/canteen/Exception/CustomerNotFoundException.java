package com.org.canteen.Exception;

import javassist.NotFoundException;

public class CustomerNotFoundException extends NotFoundException{

	public CustomerNotFoundException() {
		super("Could not find customer with given id ");
	}
	
	CustomerNotFoundException(Long id) {
		super("Could not find customer with id " + id);
	}
}
