package com.desafioibgl.produtos_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome e obrigatorio")
    private String nome;

    @NotNull(message = "O preco e obrigatorio")
    @Positive(message = "O preco deve ser maior que zero")
    private Double preco;

    @NotBlank(message = "A descricao e obrigatoria")
    private String descricao;

    @NotBlank(message = "A categoria e obrigatoria")
    private String categoria;
}