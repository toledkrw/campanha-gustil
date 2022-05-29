package com.gustil.contas.Service;

import com.gustil.contas.Exceptions.FieldValidationException;

import com.gustil.contas.Model.Entities.Campanha;
import com.gustil.contas.Model.Repositories.CampanhaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CampanhaService {
    @Autowired
    CampanhaDAO campanhaDAO;

    public Campanha getCampanhaById(String id) {
        Campanha campanha = campanhaDAO.findById(Integer.parseInt(id));
        return campanha;
    }

    public Campanha getCampanhaByNome(String nome) {
        Campanha campanha = campanhaDAO.findByNome(nome);
        return campanha;
    }

    public ArrayList<Campanha> getCampanhaByData(String data) {
        ArrayList campanha = campanhaDAO.findByInicio(data);
        return campanha;
    }

//    public Campanha cadastrarCampanha(Campanha campanha) throws FieldValidationException {
//        if(campanha.getNome().isEmpty() || campanha.getNome() == null){
//            throw new FieldValidationException("Nome da campanha não pode estar vazio.");
//        }
//        if(campanha.getDescricao().isEmpty() || campanha.getDescricao() == null){
//            throw new FieldValidationException("Descrição da campanha não pode estar vazia.");
//        }
//
//        return campanhaDAO.save(campanha);
//    }

}
