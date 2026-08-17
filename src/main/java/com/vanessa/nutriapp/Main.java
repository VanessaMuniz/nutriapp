package com.vanessa.nutriapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Saudacao saudacao = new Saudacao();
        saudacao.darBoasVindas();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Novo Paciente ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Altura (m): ");
            double altura = scanner.nextDouble();


            scanner.nextLine();
            Paciente paciente = new Paciente(nome, idade, peso, altura);
            pacientes.add(paciente);

            System.out.println("Paciente cadastrado com sucesso!");


            System.out.print("Deseja cadastrar outro paciente? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }


        System.out.println("\n*** Pacientes cadastrados: " + pacientes.size() + " ***");
        for (Paciente p : pacientes) {
            System.out.println("----------------------------------");
            p.exibirPaciente();
        }
        scanner.close();
    }
}