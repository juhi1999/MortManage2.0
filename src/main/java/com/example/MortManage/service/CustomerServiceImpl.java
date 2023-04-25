package com.example.MortManage.service;

import com.example.MortManage.DAO.CustomerDAO;
import com.example.MortManage.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> FindAll() {
        return customerDAO.FindAll();
    }

    @Override
    public Customer findById(int theId) {
        return customerDAO.findById(theId);
    }

    @Override
    @Transactional
    public Customer save(Customer theCustomer) {
        return customerDAO.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);

    }


    @Override
    @Transactional
    public Customer updateCustomer( Customer c, int id) {

        Customer customerDB= findById(id);
        if(Objects.nonNull(c.getContact()) && !"".equalsIgnoreCase(c.getContact())){
            customerDB.setContact(c.getContact());
        }

        if (Objects.nonNull(c.getAddress()) && !"".equalsIgnoreCase(c.getAddress())){
            customerDB.setAddress(c.getAddress());
        }

        if (Objects.nonNull(c.getEmail()) && !"".equalsIgnoreCase(c.getEmail())){
            customerDB.setEmail(c.getEmail());
        }

        if (Objects.nonNull(c.getLastname()) && !"".equalsIgnoreCase(c.getLastname())){
            customerDB.setLastname(c.getLastname());
        }

        if (Objects.nonNull(c.getFirstname()) && !"".equalsIgnoreCase(c.getFirstname())){
            customerDB.setFirstname(c.getFirstname());
        }

        if (Objects.nonNull(c.getMortgages()) ){
            customerDB.setMortgages(c.getMortgages());
        }

        return save(customerDB);

    }


}
