package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;
import com.example.MortManage.entity.Mortgage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MortgageDAOImpl implements MortgageDAO{
    private EntityManager entityManager;

    public MortgageDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Mortgage> FindAll() {
        TypedQuery<Mortgage> theQuery =  entityManager.createQuery("from Mortgage", Mortgage.class);
        List<Mortgage> mortgages=theQuery.getResultList();

        //return the results
        return mortgages;
    }

    @Override
    public Mortgage findById(int theId) {
        //get Customer
        Mortgage theMortgage= entityManager.find(Mortgage.class,theId);

        return theMortgage;
    }

    @Override
    public Mortgage save(Mortgage theMortgage) {
        //save customer //save or update depends on id= 0 or not
        Mortgage dbMortgage= entityManager.merge(theMortgage);

        //return the customer updated.
        return dbMortgage;
    }

    @Override
    public void deleteById(int theId) {
        //find the customer
        Mortgage theMortgage=entityManager.find(Mortgage.class,theId);
        //remove employee
        entityManager.remove(theMortgage);

    }
}
