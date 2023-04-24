package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;
import com.example.MortManage.entity.Mortgage;

import java.util.List;

public interface CustomerDAO {

    List<Customer> FindAll();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void deleteById(int theId);

}
