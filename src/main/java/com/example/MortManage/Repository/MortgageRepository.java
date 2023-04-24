package com.example.MortManage.Repository;

import com.example.MortManage.entity.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRepository extends JpaRepository<Mortgage,Integer> {
}
