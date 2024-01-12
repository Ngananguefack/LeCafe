package com.example.demo.repository;

import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
//    @Query("Select c from commande c where c.statut='en cours'")
//    Commande findCommandeEnCours();
}
