package com.vanessa.nutriapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("NutriApp iniciado com sucesso!");

        Saudacao saudacao = new Saudacao();
        saudacao.darBoasVindas();

        Paciente paciente1 = new Paciente("Ana", 33, 78.00,1.75);
        Paciente paciente2 = new Paciente("Carlos", 38, 85.00,1.85);

        paciente1.exibirPaciente();
        paciente2.exibirPaciente();
    }
}