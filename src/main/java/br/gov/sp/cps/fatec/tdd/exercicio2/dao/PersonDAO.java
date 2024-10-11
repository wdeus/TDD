package br.gov.sp.cps.fatec.tdd.exercicio2.dao;

import br.gov.sp.cps.fatec.tdd.exercicio2.entity.Email;
import br.gov.sp.cps.fatec.tdd.exercicio2.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person person){
        List<String> erros = new ArrayList<>();

        if (person.getName() == null || person.getName().split(" ").length < 2) {
            erros.add("O nome deve ser composto por ao menos 2 partes");
        } else if (!person.getName().matches("[a-zA-Z\\s]+")) {
            erros.add("O nome deve ser composto de letras");
        }

        if (person.getAge() == null || person.getAge() < 1 || person.getAge() > 200) {
            erros.add("A idade deve estar no intervalo [1,200]");
        }

        if (person.getEmails() == null || person.getEmails().isEmpty()) {
            erros.add("O objeto Person deve ter pelo menos um objeto da classe Email associado");
        } else {

            for (Email email : person.getEmails()) {
                if (!email.getName().matches("\\S+@\\S+\\.\\S+")) {
                    erros.add("O email deve estar no formato correto (____@____._____)");
                }
            }
        }
        return erros;
    }
}
