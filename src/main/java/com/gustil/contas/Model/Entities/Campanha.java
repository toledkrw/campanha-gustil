package com.gustil.contas.Model.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Campanha {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 100, nullable = false)
    String nome;
    @Column(length = 500, nullable = false)
    String descricao;

    @Column(length = 1000, nullable = true)
    String acoes, duracao, plano;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern ="dd/MM/yyyy" )
    LocalDate inicio;

    Double investimento;
    Double percentual_concluido;

//    List<Objects> publico_alvo;
    String publico_alvo;
}
