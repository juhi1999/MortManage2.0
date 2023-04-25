package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;
import com.example.MortManage.entity.Mortgage;

import java.util.List;

public interface MortgageDAO {

    List<Mortgage> FindAll();

    Mortgage findById(int theId);

    Mortgage save(Mortgage theMortgage);

    void deleteById(int theId);

    List<Mortgage> isActive();

    List<Mortgage> findMortgageByCustomerId(int customerId);

}
