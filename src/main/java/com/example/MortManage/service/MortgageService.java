package com.example.MortManage.service;

import com.example.MortManage.entity.Mortgage;

import java.util.List;

public interface MortgageService {
    List<Mortgage> FindAll();

    Mortgage findById(int theId);

    Mortgage save(Mortgage theMortgage);

    void deleteById(int theId);
}
