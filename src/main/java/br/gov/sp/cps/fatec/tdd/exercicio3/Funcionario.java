package br.gov.sp.cps.fatec.tdd.exercicio3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Funcionario {

    private String nome;
    private String email;
    private double salario;
    private Cargo cargo;
}
