package com.carrinho.carrinho.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jogo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank
    String nome;
    @NotBlank
    String classificaçao;
    @NotBlank
    String preco;
    @NotBlank
    String desenvolvedores;
    @NotBlank
    String genero;
    @NotBlank
    String dataDeLancamento;
    @NotBlank
    String plataformas;
    Date deleted;
}