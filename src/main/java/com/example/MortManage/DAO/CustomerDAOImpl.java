package com.example.MortManage.DAO;

import com.example.MortManage.Repository.CustomerRepository;
import com.example.MortManage.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;
    private CustomerRepository customerRepository;



    public CustomerDAOImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer save(Customer theCustomer) {

        //save customer //save or update depends on id= 0 or not
       Customer dbCustomer= entityManager.merge(theCustomer);

        //return the customer updated.
        return dbCustomer;
    }

    @Override
    public void deleteById(int theId) {

        //find the customer
        Customer theCustomer=entityManager.find(Customer.class,theId);
        //remove employee
        entityManager.remove(theCustomer);

    }

//
//    @Override
//    public Customer updateContact(int id, Customer c) {
//
//        Customer customerDB= customerRepository.getReferenceById(id);
//        if(Objects.nonNull(c.getContact()) && !"".equalsIgnoreCase(c.getContact())){
//            customerDB.setContact(c.getContact());
//        }
//
//        if (Objects.nonNull(c.getAddress()) && !"".equalsIgnoreCase(c.getAddress())){
//            customerDB.setAddress(c.getAddress());
//        }
//
//        if (Objects.nonNull(c.getEmail()) && !"".equalsIgnoreCase(c.getEmail())){
//            customerDB.setEmail(c.getEmail());
//        }
//
//        if (Objects.nonNull(c.getLastname()) && !"".equalsIgnoreCase(c.getLastname())){
//            customerDB.setLastname(c.getLastname());
//        }
//
//        if (Objects.nonNull(c.getFirstname()) && !"".equalsIgnoreCase(c.getFirstname())){
//            customerDB.setFirstname(c.getFirstname());
//        }
//
//        if (Objects.nonNull(c.getMortgages()) ){
//            customerDB.setMortgages(c.getMortgages());
//        }
//
//        return customerRepository.save(customerDB);
//
//    }

    @Override
    public List<Customer> FindAll() {
        //create a query
        TypedQuery<Customer> theQuery= entityManager.createQuery("from Customer",Customer.class);

        //execute query and get result
        List<Customer> customers=theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public Customer findById(int theId) {

        //get Customer
        Customer theCustomer= entityManager.find(Customer.class,theId);

        return theCustomer;
    }


    @Override
    public Customer updateCustomer(Customer c, int id) {
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
