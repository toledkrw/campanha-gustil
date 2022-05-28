package com.gustil.contas.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Campanha {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 100, nullable = false)
    String nome;
    @Column(length = 500, nullable = false)
    String descrição;

    @Column(length = 1000, nullable = true)
    String ações, duração, plano;

    Date inicio;

    Integer investimento;
    Double percentual_concluído;
}
