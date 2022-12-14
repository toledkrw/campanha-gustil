package com.gustil.contas.Service;

import com.gustil.contas.Exceptions.FailToUpdateException;
import com.gustil.contas.Exceptions.FieldValidationException;

import com.gustil.contas.Model.Entities.Campanha;
import com.gustil.contas.Model.Repositories.Campanha.CampanhaDAO;
import com.gustil.contas.Model.Repositories.Campanha.CampanhaDTO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public ArrayList<Campanha> getCampanhaByData(LocalDate data) {
        ArrayList campanha = campanhaDAO.findByInicio(data);
        return campanha;
    }

    public Campanha cadastrarCampanha(CampanhaDTO campanha) throws FieldValidationException {
        Campanha entidade = new Campanha(null, campanha.getNome(), campanha.getDescricao(), campanha.getAcoes(), campanha.getDuracao(), campanha.getPlano(), campanha.getInicio(), campanha.getInvestimento(), campanha.getPercentual_concluido(), null);
        return campanhaDAO.save(entidade);
    }

    public ArrayList<Campanha> getCampanhas() {
        ArrayList<Campanha> campanhas = campanhaDAO.findAll();
        return campanhas;
    }

    public void adicionarPublicoAlvoId(Integer id, String publico, String campanha) throws FailToUpdateException {
        Campanha check = null;
        if(id == null){
            check = campanhaDAO.findByNome(campanha);
            if(check != null){
                campanhaDAO.updatePublicoAlvo(check.getId(), publico);
            }
        }

        else{
            check = campanhaDAO.findById(id);
            if(check != null){
                campanhaDAO.updatePublicoAlvo(check.getId(), publico);
            }
            else{
                throw  new FailToUpdateException("Falha ao fazer update");
            }
        }
    }
}
