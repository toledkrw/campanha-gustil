package com.gustil.contas.Controller;

import com.gustil.contas.Model.Entities.Campanha;
import com.gustil.contas.Service.CampanhaService;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

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
            return ResponseEntity.ok().body(campanhaService.getCampanhaByData(data));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/cadastrar")
//    public ResponseEntity<Campanha> cadastrarCampanha(@RequestBody Campanha campanha){
//        try{
//            campanhaService.cadastrarCampanha(campanha);
//            return ResponseEntity.status(201).build();
//        }
//        catch(Exception e){
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
