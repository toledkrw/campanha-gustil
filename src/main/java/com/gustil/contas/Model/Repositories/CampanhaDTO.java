package com.gustil.contas.Model.Repositories;

import javax.persistence.Column;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampanhaDTO {

    @Column(length = 100, nullable = false)
    String nome;
    @Column(length = 500, nullable = false)
    String descricao;

    @Column(length = 1000, nullable = true)
    String acoes, duracao, plano;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    LocalDate inicio;

    Double investimento;
    Double percentual_concluido;
}
