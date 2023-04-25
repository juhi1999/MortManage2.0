package com.example.MortManage.Repository;

import com.example.MortManage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//    @Modifying
//    @Query("update Customer u set u.contact = ?1 where u.id = ?2")
//    void updatePhone(String phone, int id);


}
