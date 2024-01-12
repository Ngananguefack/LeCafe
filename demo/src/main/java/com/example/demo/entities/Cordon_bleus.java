package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Cordon_bleus")
public class Cordon_bleus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String Email;
    public String Adress;
    public int tel;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Cordons_Menu",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "idMenu")}
    )
    public Set<Menu> menus = new HashSet<>();

    @OneToMany(mappedBy = "cordon_bleus")
    public List<Commande> commandes;

    public Cordon_bleus(int id, String name, String email, String adress, int tel, Set<Menu> menus, List<Commande> commandes) {
        this.id = id;
        this.name = name;
        Email = email;
        Adress = adress;
        this.tel = tel;
        this.menus = menus;
        this.commandes = commandes;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Cordon_bleus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                ", Adress='" + Adress + '\'' +
                ", tel=" + tel +
                ", menus=" + menus +
                ", commandes=" + commandes +
                '}';
    }

    public Cordon_bleus() {
        super();
    }
}
