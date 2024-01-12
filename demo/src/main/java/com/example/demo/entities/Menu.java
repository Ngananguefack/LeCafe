package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idMenu;
    public String nameMenu;

    @ManyToMany(mappedBy = "menus")
    public Set<Cordon_bleus> cordon_bleus= new HashSet<>();

    @ManyToMany(mappedBy = "menus")
    public Set<Gerant> gerants= new HashSet<>();

    @ManyToMany(mappedBy = "menus")
    public Set<Item> items= new HashSet<>();

    @ManyToMany(mappedBy = "menus")
    public Set<Serveur> serveurs= new HashSet<>();

    public Menu(int idMenu, String nameMenu) {
        this.idMenu = idMenu;
        this.nameMenu = nameMenu;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", nameMenu='" + nameMenu + '\'' +
                '}';
    }

    public Menu() {
        super();
    }
}
