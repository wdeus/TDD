package br.gov.sp.cps.fatec.tdd.exercicio1;

public class Triangulo {

    public static String obterTipoTriangulo(int lado1, int lado2, int lado3) {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new IllegalArgumentException("Valores inválidos");
        }

        if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
            throw new IllegalArgumentException("A soma de dois lados tem que ser maior que o terceiro lado");
        }

        if (lado1 == lado2 && lado2 == lado3) {
            return TipoTriangulo.EQUILATERO.name();
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return TipoTriangulo.ISOCELES.name();
        } else {
            return TipoTriangulo.ESCALENO.name();
        }
    }
}
