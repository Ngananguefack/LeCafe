package com.example.demo.repository;

import com.example.demo.entities.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Integer> {
}
