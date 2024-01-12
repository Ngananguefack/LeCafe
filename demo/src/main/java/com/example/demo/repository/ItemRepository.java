package com.example.demo.repository;

import com.example.demo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

//     @Query("select *Item_name from Item")
//     String getItem_name();
}
