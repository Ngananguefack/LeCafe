package com.example.demo.repository;

import com.example.demo.entities.Ligne_Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ligne_CommandeRepository extends JpaRepository<Ligne_Commande, Integer> {
}
