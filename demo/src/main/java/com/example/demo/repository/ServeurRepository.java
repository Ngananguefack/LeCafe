package com.example.demo.repository;

import com.example.demo.entities.Serveur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeurRepository extends JpaRepository<Serveur, Integer> {

}
