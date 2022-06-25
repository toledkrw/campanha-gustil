package com.gustil.contas.Model.Repositories.Campanha;

import com.gustil.contas.Model.Entities.Campanha;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;

@Transactional
@Repository
public interface CampanhaDAO extends JpaRepository <Campanha,String> {
    public Campanha findById(Integer id);
    public Campanha findByNome(String nome);

    public ArrayList<Campanha> findByInicio(LocalDate inicio);

    public ArrayList<Campanha> findAll();

    @Modifying
    @Query(value = "UPDATE CAMPANHA c SET c.publico_alvo = :publico WHERE c.id = :id", nativeQuery = true)
    public void updatePublicoAlvo(@Param("id") Integer Id, @Param("publico") String publico);

}
