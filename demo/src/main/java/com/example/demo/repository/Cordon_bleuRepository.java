package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Cordon_bleus;
import org.springframework.stereotype.Repository;

@Repository
public interface Cordon_bleuRepository extends JpaRepository<Cordon_bleus, Integer> {

}
