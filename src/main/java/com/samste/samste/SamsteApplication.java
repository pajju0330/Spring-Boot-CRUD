package com.samste.samste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customer")
public class SamsteApplication {
	private final CustomerRepository customerRepository;

	public SamsteApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SamsteApplication.class, args);
	}

	@GetMapping
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	record  NewCustomerRequest(String name, Integer age, String email){}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request){
		Customer newCustomer = new Customer();
		newCustomer.setAge(request.age);
		newCustomer.setEmail(request.email);
		newCustomer.setName(request.name);
		customerRepository.save(newCustomer);
	}

	record deleteRequest(Integer id){}
	@DeleteMapping
	public String deleteCustomerById(@RequestBody deleteRequest request){
		customerRepository.deleteById(request.id);
		return "Customer Deleted Successfully";
	}


	record updateRequest(Integer id, String name, String email, Integer age){}

	@PutMapping
	public Customer updateCustomer(@RequestBody updateRequest request){
		Customer customer = customerRepository.findById(request.id()).orElse(null);
		if(customer == null) return null;
		customer.setName(request.name);
		customer.setEmail(request.email);
		customer.setAge(request.age());
		customerRepository.save(customer);
		return customer;
	}

//	class Customer{
//		private int Id;
//		private String name;
//		public Customer(){}
//		public Customer(int id, String name){
//			this.Id = id;
//			this.name = name;
//		}
//
//		public int getId() {
//			return Id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//	}

}
