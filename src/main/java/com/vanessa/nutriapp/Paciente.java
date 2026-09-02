package com.vanessa.nutriapp;

public class Paciente {

    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Paciente(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida! Mantendo valor anterior.");
        }
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            System.out.println("Peso inválido! Mantendo valor anterior.");
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Altura inválida! Mantendo valor anterior.");
        }
    }

    public void exibirPaciente() {
        System.out.println("Paciente: " + nome);
        System.out.println("Idade: " + idade + "anos");
        System.out.println("Peso: " + peso + "Kg");
        System.out.println("Altura: " + altura + "m");
    }

}
