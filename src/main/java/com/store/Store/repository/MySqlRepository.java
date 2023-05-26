package com.store.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.Store.model.Address;

public interface MySqlRepository extends JpaRepository<Address, Integer> {
    
}
