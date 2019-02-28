/**
 * 
 */
package com.org.canteen.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.canteen.Exception.CustomerNotFoundException;
import com.org.canteen.api.model.Customer;
import com.org.canteen.api.repository.CustomerRepository;
import com.org.canteen.vo.CustomerVO;

/**
 * @author pavas.s
 *
 */
@Service
public class CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	public Customer addCustomer(CustomerVO customerVO) {

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVO, customer);
		return customerRepository.save(customer);

	}

	public Customer editCustomer(int id, CustomerVO customerVO) {

		Customer customer;
		try {
			customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
			BeanUtils.copyProperties(customerVO, customer);
			return customerRepository.save(customer);
		} catch (CustomerNotFoundException e) {

			LOGGER.error(String.format("Customer for id %d is Not Found", id));
		}
		return null;
	}

	public void deleteCustomer(int id) {
		Customer customer;
		try {
			customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
			customerRepository.delete(customer);
		} catch (CustomerNotFoundException e) {
			LOGGER.error(String.format("Customer for id %d is Not Found", id));
		}

	}
}
