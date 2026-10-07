package br.com.lojamaven;

import java.math.BigDecimal;
import java.util.Objects;

public record Produto(String nome, BigDecimal preco) {

    public Produto {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        Objects.requireNonNull(preco, "O preço do produto é obrigatório.");

        if (preco.signum() <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }
    }
}