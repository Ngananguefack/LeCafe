package com.example.demo.Controller;

import com.example.demo.entities.Commande;
import com.example.demo.entities.Item;
import com.example.demo.entities.Ligne_Commande;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {
    @Autowired
    public ItemRepository itemRepository;
    @GetMapping(path="/additem")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping(path="/item")
    public String addItems(@ModelAttribute("additem") @Validated Item item, BindingResult result,
                           @RequestParam("image")MultipartFile image, Model model) throws IOException{
        System.out.println(item.Item_name);
        System.out.println(image);
//        if(result.hasErrors()){
//            return "itemslist";
//        }
        if(!image.isEmpty()){
            item.setImage(image.getBytes());
        }
        itemRepository.save(item);
        return "redirect:/Item";
    }

//    @Autowired
//    public CommandeRepository commandeRepository;
//    @GetMapping(path = "/item/{id}")
//    public String afficherItems(@PathVariable Integer idItem, Model model){
//         Item item= itemRepository.findById(idItem).orElseThrow(()-> new IllegalArgumentException("Item invalide:"+ idItem));
//        //Optional<Item> item= itemRepository.findById(idItem);
//        model.addAttribute("item", item);
//        model.addAttribute("ligneCommande", new Ligne_Commande());
//        return "item";
//
//    }
//
//    @PostMapping("/produit/{id}")
//    public String ajouterAuPanier(@PathVariable Integer idItem, @ModelAttribute Ligne_Commande ligne_commande){
//        Item item=itemRepository.findById(idItem).orElseThrow(()->new IllegalArgumentException("item invalide:"+idItem));
//        Commande commande= commandeRepository.findCommandeEnCours();
//        if (commande==null){
//            commande=new Commande();
//            commande.setStatut("en cours");
//            List<Ligne_Commande> ligne_commandes= new ArrayList<>();
//        }
//        for (Ligne_Commande lc:
//             ) {
//
//        }
//    }
}
