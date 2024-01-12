package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ingredient")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public int Cost;
    public String Description;

    @ManyToMany(mappedBy = "ingredients")
    public Set<Item> items= new HashSet<>();

    public Ingredients(int id, String name, int cost, String description, Set<Item> items) {
        this.id = id;
        this.name = name;
        Cost = cost;
        Description = description;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Cost=" + Cost +
                ", Description='" + Description + '\'' +
                ", items=" + items +
                '}';
    }

    public Ingredients() {
        super();
    }
}
