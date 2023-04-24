package com.example.MortManage.rest;

import com.example.MortManage.Repository.MortgageRepository;
import com.example.MortManage.entity.Customer;
import com.example.MortManage.entity.Mortgage;
import com.example.MortManage.service.MortgageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MortgageRestController {

    private MortgageService mortgageService;

    public MortgageRestController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @GetMapping("/mortgages")
    public List<Mortgage> FindAll(){
        return mortgageService.FindAll();
    }

    @GetMapping("/mortgages/active")
    public List<Mortgage> ActiveMortgages()
    {
        return mortgageService.isActive();
    }

    @GetMapping("/mortgage/{customerId}")
    public List<Mortgage> findMortgagesByCustomerId(@PathVariable int customerId){
        return mortgageService.findMortgageByCustomerId(customerId);
    }

}
