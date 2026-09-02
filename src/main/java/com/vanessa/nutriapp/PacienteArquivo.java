package com.vanessa.nutriapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PacienteArquivo {


    private static final String NOME_ARQUIVO = "pacientes.csv";

    // SALVA a lista inteira de pacientes no arquivo
    public static void salvar(ArrayList<Paciente> pacientes) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {

            for (Paciente p : pacientes) {
                // Monta uma linha: nome;idade;peso;altura
                String linha = p.getNome() + ";" + p.getIdade() + ";" + p.getPeso() + ";" + p.getAltura();
                escritor.write(linha);
                escritor.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar os pacientes: " + e.getMessage());
        }
    }

    // CARREGA os pacientes do arquivo para uma lista
    public static ArrayList<Paciente> carregar() {
        ArrayList<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(NOME_ARQUIVO))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Quebra a linha nos ";" para separar os dados
                String[] dados = linha.split(";");

                String nome = dados[0];
                int idade = Integer.parseInt(dados[1]);
                double peso = Double.parseDouble(dados[2]);
                double altura = Double.parseDouble(dados[3]);

                Paciente paciente = new Paciente(nome, idade, peso, altura);
                pacientes.add(paciente);
            }

        } catch (IOException e) {
            // Se o arquivo ainda não existe (primeira execução), apenas começa vazio
            System.out.println("Nenhum arquivo de pacientes encontrado. Começando do zero.");
        }

        return pacientes;
    }
}