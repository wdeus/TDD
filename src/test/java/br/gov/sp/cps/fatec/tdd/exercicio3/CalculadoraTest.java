package br.gov.sp.cps.fatec.tdd.exercicio3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2000, 1800",
            "3000, 2400",
            "4000, 3200"
    })
    void deveCalcularSalarioLiquidoDoDesenvolvedor(double salario, double resultadoEsperado) {
        Funcionario funcionario = Funcionario.builder()
                .salario(salario)
                .cargo(Cargo.DESENVOLVEDOR)
                .build();
        assertEquals(resultadoEsperado, Calculadora.calcularSalarioLiquido(funcionario));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000, 850",
            "2000, 1500",
            "3000, 2250"
    })
    void deveCalcularSalarioLiquidoDoDBA(double salario, double resultadoEsperado) {
        Funcionario funcionario = Funcionario.builder()
                .salario(salario)
                .cargo(Cargo.DBA)
                .build();
        assertEquals(resultadoEsperado, Calculadora.calcularSalarioLiquido(funcionario));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000, 850",
            "2000, 1500",
            "3000, 2250"
    })
    void deveCalcularSalarioLiquidoDoTestador(double salario, double resultadoEsperado) {
        Funcionario funcionario = Funcionario.builder()
                .salario(salario)
                .cargo(Cargo.TESTADOR)
                .build();
        assertEquals(resultadoEsperado, Calculadora.calcularSalarioLiquido(funcionario));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4000, 3200",
            "5000, 3500",
            "6000, 4200"
    })
    void deveCalcularSalarioLiquidoDoGerente(double salario, double resultadoEsperado) {
        Funcionario funcionario = Funcionario.builder()
                .salario(salario)
                .cargo(Cargo.GERENTE)
                .build();
        assertEquals(resultadoEsperado, Calculadora.calcularSalarioLiquido(funcionario));
    }
}