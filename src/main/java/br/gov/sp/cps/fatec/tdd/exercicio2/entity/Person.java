package br.gov.sp.cps.fatec.tdd.exercicio2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Person {

    private Long id;
    private String name;
    private Long age;
    private List<Email> emails;
}
