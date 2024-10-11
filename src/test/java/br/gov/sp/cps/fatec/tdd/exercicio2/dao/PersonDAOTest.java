package br.gov.sp.cps.fatec.tdd.exercicio2.dao;

import br.gov.sp.cps.fatec.tdd.exercicio2.entity.Email;
import br.gov.sp.cps.fatec.tdd.exercicio2.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    PersonDAO personDAO = new PersonDAO();

    @ParameterizedTest
    @CsvSource({
            "'Wagner', 'O nome deve ser composto por ao menos 2 partes'",
            "'Wagner Junior11', 'O nome deve ser composto de letras'"
    })
    void deveRetornarErroSeONomeForInvalido(String nome, String mensagemEsperada) {
        Person person = new Person();
        person.setName(nome);
        person.setAge(21L);
        person.setEmails(Arrays.asList(new Email(1L, "wagner@gmail.com")));

        List<String> erros = personDAO.isValidToInclude(person);

        assertTrue(erros.contains(mensagemEsperada));
    }


    @ParameterizedTest
    @CsvSource({
            "0, 'A idade deve estar no intervalo [1,200]'",
            "201, 'A idade deve estar no intervalo [1,200]'"
    })
    void deveRetornarErroSeAIdadeForInvalida(Long idade, String mensagemEsperada) {
        Person person = new Person();
        person.setName("Wagner Junior");
        person.setAge(idade);
        person.setEmails(Arrays.asList(new Email(1L, "wagner@gmail.com")));

        List<String> erros = personDAO.isValidToInclude(person);

        assertTrue(erros.contains(mensagemEsperada));
    }


    @ParameterizedTest
    @CsvSource({
            "'wagner.com', O email deve estar no formato correto (____@____._____)",
            "'wagner@gmail', O email deve estar no formato correto (____@____._____)",
            "'@gmail.com', O email deve estar no formato correto (____@____._____)",
            "'wagner@.com', O email deve estar no formato correto (____@____._____)",
            "'wagner@gmail.', O email deve estar no formato correto (____@____._____)"
    })
    void deveRetornarErroSeEmailForInvalido(String email, String mensagemEsperada) {
        Person person = new Person();
        person.setName("Wagner Junior");
        person.setAge(21L);
        person.setEmails(Arrays.asList(new Email(1L, email)));

        List<String> erros = personDAO.isValidToInclude(person);

        assertTrue(erros.contains(mensagemEsperada));
    }


    @ParameterizedTest
    @CsvSource({
            "'Wagner Junior', 21, 'O objeto Person deve ter pelo menos um objeto da classe Email associado'"
    })
    void deveRetornarErroSeNaoTiverEmails(String nome, Long idade, String mensagemEsperada) {
        Person person = new Person();
        person.setName(nome);
        person.setAge(idade);
        person.setEmails(Collections.emptyList());

        List<String> erros = personDAO.isValidToInclude(person);

        assertTrue(erros.contains(mensagemEsperada));
    }


    @ParameterizedTest
    @CsvSource({
            "'Wagner Junior', 21, 'wagner@gmail.com'"
    })
    void deveRetornarListaVaziaSeDadosForemValidos(String nome, Long idade, String email) {
        Person person = new Person();
        person.setName(nome);
        person.setAge(idade);
        person.setEmails(Arrays.asList(new Email(1L, email)));

        List<String> erros = personDAO.isValidToInclude(person);

        assertTrue(erros.isEmpty());
    }
}