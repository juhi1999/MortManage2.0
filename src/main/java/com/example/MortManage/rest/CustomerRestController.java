package com.example.MortManage.rest;

import com.example.MortManage.entity.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    List<Customer> theCustomers;

}
