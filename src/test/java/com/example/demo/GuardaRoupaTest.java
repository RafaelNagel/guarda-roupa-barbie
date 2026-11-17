package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {

    private GuardaRoupa guardaRoupa;

    @BeforeEach
    void setUp() {
        guardaRoupa = new GuardaRoupa(500.0);
    }

    @Test
    void deveCalcularDezPorCentoDeDescontoEmDuzentos() {
        double resultado = guardaRoupa.precoComDesconto(200, 10);

        assertEquals(180.0, resultado, 0.001);
    }

    @Test
    void deveLancarExcecaoParaDescontoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> guardaRoupa.precoComDesconto(200, -10)
        );
    }

    @Test
    void deveLancarExcecaoParaDescontoAcimaDeCem() {
        assertThrows(
                IllegalArgumentException.class,
                () -> guardaRoupa.precoComDesconto(200, 110)
        );
    }

    @Test
    void deveAceitarPrecoAbaixoDoOrcamento() {
        assertTrue(guardaRoupa.cabeNoOrcamento(300));
    }

    @Test
    void deveAceitarPrecoExatamenteIgualAoOrcamento() {
        assertTrue(guardaRoupa.cabeNoOrcamento(500));
    }

    @Test
    void naoDeveSerGalaAbaixoDeDuzentos() {
        assertFalse(guardaRoupa.ehDeGala(199));
    }

    @Test
    void naoDeveSerGalaExatamenteDuzentos() {
        assertFalse(guardaRoupa.ehDeGala(200));
    }

    @Test
    void deveSerGalaAcimaDeDuzentos() {
        assertTrue(guardaRoupa.ehDeGala(201));
    }
}
