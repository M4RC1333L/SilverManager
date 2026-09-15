//package com.silvermanager.service;//

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculoVendaTest {

    // Método de regra de negócio simples (sem acesso ao banco de dados)
    public double calcularDesconto(double valorTotal, double percentualDesconto) {
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }
        return valorTotal - (valorTotal * (percentualDesconto / 100));
    }

    @Test
    public void testCalcularDescontoComSucesso() {
        double valorTotal = 100.0;
        double desconto = 10.0; // 10%
        double valorEsperado = 90.0;

        double valorObtido = calcularDesconto(valorTotal, desconto);

        // Valida se o cálculo do desconto está correto
        assertEquals(valorEsperado, valorObtido, 0.001);
    }
}