package com.example.demo.Controller;

import com.example.demo.entities.Ligne_Commande;
import com.example.demo.repository.Ligne_CommandeRepository;
import com.example.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ligne_commande")
public class MenuControlleur {
   @Autowired
   public Ligne_CommandeRepository ligne_commandeRepository;
    @PostMapping("add")
    public ResponseEntity<String> ajoutlignecommande(@RequestBody Ligne_Commande ligne_commande) {
        ligne_commandeRepository.save(ligne_commande);
        return new ResponseEntity<>("commande ajouté", HttpStatus.OK);
    }
}
