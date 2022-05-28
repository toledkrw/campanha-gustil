package com.gustil.contas.Model.Repositories;

import com.gustil.contas.Model.Entities.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampanhaDAO extends JpaRepository <Campanha,String> {

}
