package com.org.canteen.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.canteen.Exception.CustomerNotFoundException;
import com.org.canteen.api.model.Customer;
import com.org.canteen.api.service.CustomerService;
import com.org.canteen.vo.CustomerVO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		LOGGER.debug("fetch all customers controller");
		
		List<Customer> customers = customerService.getAllCustomers();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) throws NotFoundException {
		LOGGER.debug("fetch customer controller");
		
		Customer customer = customerService.getCustomerById(id).orElseThrow(CustomerNotFoundException::new);;

//		if (customerService.getCustomerById(id).isPresent())
//			customer = customerService.getCustomerById(id).get();
//		else
//			throw new NotFoundException("Customer for id " + id + " is Not Found");

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerVO customerVO) {
		LOGGER.debug("add customer controller");
		
		Customer customerAdded = customerService.addCustomer(customerVO);

		return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> editCustomer(@PathVariable int id, @RequestBody CustomerVO customerVO) {
		LOGGER.debug("edit customer controller");

		Customer customerAdded = customerService.editCustomer(id, customerVO);

		return new ResponseEntity<>(customerAdded, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		LOGGER.debug("delete customer controller");

		customerService.deleteCustomer(id);

		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	

}
