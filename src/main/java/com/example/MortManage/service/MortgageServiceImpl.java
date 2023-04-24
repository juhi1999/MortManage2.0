package com.example.MortManage.service;

import com.example.MortManage.DAO.MortgageDAO;
import com.example.MortManage.entity.Mortgage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageServiceImpl implements MortgageService{

    private MortgageDAO mortgageDAO;

    @Autowired
    public MortgageServiceImpl(MortgageDAO mortgageDAO) {
        this.mortgageDAO = mortgageDAO;
    }

    @Override
    public List<Mortgage> FindAll() {
        return mortgageDAO.FindAll();
    }

    @Override
    public Mortgage findById(int theId) {
        return mortgageDAO.findById(theId);
    }

    @Override
    public Mortgage save(Mortgage theMortgage) {
        return mortgageDAO.save(theMortgage);
    }

    @Override
    public void deleteById(int theId) {
        mortgageDAO.deleteById(theId);

    }

    @Override
    public List<Mortgage> isActive() {
       return mortgageDAO.isActive();
    }

    @Override
    public List<Mortgage> findMortgageByCustomerId(int customerId) {
        return mortgageDAO.findMortgageByCustomerId(customerId);
    }

}
