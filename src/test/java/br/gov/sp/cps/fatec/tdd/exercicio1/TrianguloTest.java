package br.gov.sp.cps.fatec.tdd.exercicio1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TrianguloTest {

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, ESCALENO",
            "5, 5, 3, ISOCELES",
            "5, 5, 5, EQUILATERO"
    })
    void deveRetornarTriangulosValidos(int lado1, int lado2, int lado3, String resultadoEsperado) {
        String resultadoAtual = Triangulo.obterTipoTriangulo(lado1, lado2, lado3);
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 7, 4, ISOCELES",
            "4, 7, 7, ISOCELES",
            "7, 4, 7, ISOCELES"
    })
    void deveRetornarTrianguloIsoscelesComPermutacoes(int lado1, int lado2, int lado3, String resultadoEsperado) {
        String resultadoAtual = Triangulo.obterTipoTriangulo(lado1, lado2, lado3);
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 5, 5, Valores inválidos",
            "-3, 4, 5, Valores inválidos",
            "0, 0, 0, Valores inválidos"
    })
    void deveLancarExceptionParaValoresInvalidos(int lado1, int lado2, int lado3, String mensagemEsperada) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.obterTipoTriangulo(lado1, lado2, lado3);
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5, 8, A soma de dois lados tem que ser maior que o terceiro lado",
            "5, 8, 3, A soma de dois lados tem que ser maior que o terceiro lado",
            "8, 3, 5, A soma de dois lados tem que ser maior que o terceiro lado"
    })
    void deveLancarExceptionParaValoresOndeASomaDoisLadosIgualTerceiro(int lado1, int lado2, int lado3, String mensagemEsperada) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.obterTipoTriangulo(lado1, lado2, lado3);
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 10, A soma de dois lados tem que ser maior que o terceiro lado",
            "10, 3, 4, A soma de dois lados tem que ser maior que o terceiro lado",
            "4, 10, 3, A soma de dois lados tem que ser maior que o terceiro lado"
    })
    void deveLancarExceptionParaValoresOndeASomaDoisLadosMenorTerceiro(int lado1, int lado2, int lado3, String mensagemEsperada) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.obterTipoTriangulo(lado1, lado2, lado3);
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

}