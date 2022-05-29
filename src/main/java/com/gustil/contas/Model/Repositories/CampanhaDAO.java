package com.gustil.contas.Model.Repositories;

import com.gustil.contas.Model.Entities.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;

public interface CampanhaDAO extends JpaRepository <Campanha,String> {
    public Campanha findById(Integer id);
    public Campanha findByNome(String nome);

    public ArrayList<Campanha> findByInicio(String inicio);
}
