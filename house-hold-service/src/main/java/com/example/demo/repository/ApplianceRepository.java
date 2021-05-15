package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ApplianceEntity;

@Repository
public interface ApplianceRepository extends JpaRepository<ApplianceEntity,Integer>{

    @Query("SELECT details FROM ApplianceEntity details WHERE details.brand=?1")
    List<ApplianceEntity> findByApplianceName(String name);
    
}
