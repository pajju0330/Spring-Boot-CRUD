package com.samste.samste.controllers;

import  com.samste.samste.model.Customer;
import com.samste.samste.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
}
