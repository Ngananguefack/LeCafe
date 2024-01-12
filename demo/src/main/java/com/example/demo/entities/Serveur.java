package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Serveur")
public class Serveur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String serveur_name;
    public String Email;
    public String Adress;
    public int Tel;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Serveur_Menu",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "idMenu")}
    )
    public Set<Menu> menus = new HashSet<>();

    @OneToMany(mappedBy = "serveur")
    public List<Commande> commandes;


    public Serveur(int id, String serveur_name, String email, String adress, int tel) {
        this.id = id;
        this.serveur_name = serveur_name;
        Email = email;
        Adress = adress;
        Tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServeur_name() {
        return serveur_name;
    }

    public void setServeur_name(String serveur_name) {
        this.serveur_name = serveur_name;
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
        return Tel;
    }

    public void setTel(int tel) {
        Tel = tel;
    }

    @Override
    public String toString() {
        return "Serveur{" +
                "id=" + id +
                ", serveur_name='" + serveur_name + '\'' +
                ", Email='" + Email + '\'' +
                ", Adress='" + Adress + '\'' +
                ", Tel=" + Tel +
                '}';
    }

    public Serveur() {
        super();
    }
}
