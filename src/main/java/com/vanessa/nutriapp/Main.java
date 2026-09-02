package com.vanessa.nutriapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Saudacao saudacao = new Saudacao();
        saudacao.darBoasVindas();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Paciente> pacientes = PacienteArquivo.carregar();


        boolean executando = true;

        while (executando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Editar paciente");
            System.out.println("4 - Excluir paciente");
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
                case 3:
                    editarPaciente(scanner, pacientes);
                    break;
                case 4:
                    excluirPaciente(scanner, pacientes);
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
        PacienteArquivo.salvar(pacientes);

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

    public static void editarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente para editar.");
            return;
        }

        listarPacientes(pacientes);

        System.out.print("\nDigite o número do paciente que deseja editar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();


        int indice = numero - 1;

        if (indice < 0 || indice >= pacientes.size()) {
            System.out.println("Número inválido!");
            return;
        }

        Paciente paciente = pacientes.get(indice);

        System.out.println("Editando: " + paciente.getNome());

        System.out.print("Novo nome: ");
        paciente.setNome(scanner.nextLine());

        System.out.print("Nova idade: ");
        paciente.setIdade(scanner.nextInt());

        System.out.print("Novo peso (kg): ");
        paciente.setPeso(scanner.nextDouble());

        System.out.print("Nova altura (m): ");
        paciente.setAltura(scanner.nextDouble());
        scanner.nextLine();
        PacienteArquivo.salvar(pacientes);
        System.out.println("Paciente atualizado com sucesso!");
    }


    public static void excluirPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente para excluir.");
            return;
        }

        listarPacientes(pacientes);

        System.out.print("\nDigite o número do paciente que deseja excluir: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        int indice = numero - 1;

        if (indice < 0 || indice >= pacientes.size()) {
            System.out.println("Número inválido!");
            return;
        }

        Paciente removido = pacientes.remove(indice);
        PacienteArquivo.salvar(pacientes);
        System.out.println("Paciente '" + removido.getNome() + "' excluído com sucesso!");
    }
}