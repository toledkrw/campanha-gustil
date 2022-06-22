package com.gustil.contas.Controller;

import com.gustil.contas.Service.CampanhaService;
import com.gustil.contas.Model.Entities.Campanha;
import com.gustil.contas.Model.Repositories.CampanhaDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/campanha")
public class CampanhaController {
    @Autowired
    CampanhaService campanhaService;

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(campanhaService.getCampanhaById(id));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<Campanha> getCampanhaByNome(@PathVariable String nome){
        try{
            return ResponseEntity.ok().body(campanhaService.getCampanhaByNome(nome));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/inicio/{data}")
    public ResponseEntity<ArrayList> getCampanhaByData(@PathVariable String data){
        try{
            LocalDate localDate= LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ArrayList <Campanha> campanhas = campanhaService.getCampanhaByData(localDate);
            return ResponseEntity.ok().body(campanhas);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/*")
    public ResponseEntity<ArrayList> getCampanhas(){
        try{
            ArrayList <Campanha> campanhas = campanhaService.getCampanhas();
            return ResponseEntity.ok().body(campanhas);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Campanha> cadastrarCampanha(@RequestBody CampanhaDTO campanha){
        try{
            campanhaService.cadastrarCampanha(campanha);
            return ResponseEntity.status(201).build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
