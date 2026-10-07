package br.com.lojamaven;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    void deveCriarProdutoComNomeEPrecoValidos() {
        Produto produto = new Produto("Café", new BigDecimal("19.90"));

        assertEquals("Café", produto.nome());
        assertEquals(new BigDecimal("19.90"), produto.preco());
    }

    @Test
    void deveRejeitarPrecoIgualAZero() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Café", BigDecimal.ZERO)
        );

        assertEquals("O preço do produto deve ser maior que zero.", erro.getMessage());
    }

    @Test
    void deveRejeitarNomeEmBranco() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("  ", new BigDecimal("10.00"))
        );
    }
}