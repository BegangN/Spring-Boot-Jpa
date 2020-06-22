package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.AddNewUser;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private CustomerRepository repository;

    @Autowired
    public Controller(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewUser(@RequestBody AddNewUser addNewUser) {
        Customer customer = new Customer();

        customer.setFirstname(addNewUser.getFirstname());
        customer.setLastname(addNewUser.getLastname());

        repository.save(customer);
    }

}