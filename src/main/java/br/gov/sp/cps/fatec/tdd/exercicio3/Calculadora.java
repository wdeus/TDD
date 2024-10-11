package br.gov.sp.cps.fatec.tdd.exercicio3;

public class Calculadora {


    public static double calcularSalarioLiquido(Funcionario funcionario){
        Cargo cargo = funcionario.getCargo();
        double salarioBase = funcionario.getSalario();
        double salarioLiquido = 0d;

        switch (cargo){
            case DESENVOLVEDOR:
                if(salarioBase >= 3000d){
                    salarioLiquido = salarioBase-(salarioBase*0.2);
                }else{
                    salarioLiquido = salarioBase-(salarioBase*0.1);
                }
                break;
            case DBA, TESTADOR:
                if(funcionario.getSalario() >= 2000d){
                    salarioLiquido = salarioBase-(salarioBase*0.25);
                }else{
                    salarioLiquido = salarioBase-(salarioBase*0.15);
                }
                break;
            case GERENTE:
                if(funcionario.getSalario() >= 5000d){
                    salarioLiquido = salarioBase-(salarioBase*0.3);
                }else{
                    salarioLiquido = salarioBase-(salarioBase*0.2);
                }
                break;
        }

        return salarioLiquido;
    }
}
