package com.vanessa.nutriapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Saudacao saudacao = new Saudacao();
        saudacao.darBoasVindas();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();


        boolean executando = true;

        while (executando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes);
                    break;
                case 2:
                    listarPacientes(pacientes);
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o NutriApp. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    public static void cadastrarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
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
    }

    public static void listarPacientes(ArrayList<Paciente> pacientes) {
        System.out.println("\n*** Pacientes cadastrados: " + pacientes.size() + " ***");

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado ainda.");
            return;
        }

        for (Paciente p : pacientes) {
            System.out.println("----------------------------------");
            p.exibirPaciente();
        }
    }
}