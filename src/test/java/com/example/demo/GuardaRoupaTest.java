package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuardaRoupaTest {

    @Test
    void deveCalcularPrecoComDesconto() {
        GuardaRoupa guardaRoupa = new GuardaRoupa(500);

        double resultado = guardaRoupa.precoComDesconto(200, 10);

        assertEquals(180.0, resultado, 0.001);
    }

    @Test
    void deveAceitarDescontoEntreZeroECem() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        assertEquals(200.0, guarda.precoComDesconto(200, 0));
        assertEquals(0.0, guarda.precoComDesconto(200, 100));
    }

    @Test
    void deveRejeitarDescontoNegativo() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        assertThrows(
                IllegalArgumentException.class,
                () -> guarda.precoComDesconto(200, -10)
        );
    }

    @Test
    void deveRejeitarDescontoAcimaDeCem() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        assertThrows(
                IllegalArgumentException.class,
                () -> guarda.precoComDesconto(200, 110)
        );
    }

    @Test
    void deveAceitarPrecoIgualAoOrcamento() {
        GuardaRoupa guarda = new GuardaRoupa(200);

        assertTrue(guarda.cabeNoOrcamento(200));
    }

    @Test
    void deveRejeitarPrecoAcimaDoOrcamento() {
        GuardaRoupa guarda = new GuardaRoupa(200);

        assertFalse(guarda.cabeNoOrcamento(201));
    }

    @Test
    void deveIdentificarLookDeGalaAcimaDeDuzentos() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        assertTrue(guarda.ehDeGala(201));
    }

    @Test
    void naoDeveIdentificarLookDeDuzentosComoGala() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        assertFalse(guarda.ehDeGala(200));
    }

    @Test
    void deveDescontarCompraDoOrcamento() {
        GuardaRoupa guarda = new GuardaRoupa(500);

        guarda.registrarCompra(150);

        assertEquals(350.0, guarda.getOrcamento(), 0.001);
    }

    @Test
    void deveIdentificarVestidoDeGala() {
        GuardaRoupa guardaRoupa = new GuardaRoupa(500.0);

        assertTrue(guardaRoupa.ehDeGala(250.0));
        assertFalse(guardaRoupa.ehDeGala(200.0));
        assertFalse(guardaRoupa.ehDeGala(150.0));
    }

}
