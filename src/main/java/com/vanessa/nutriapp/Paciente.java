package com.vanessa.nutriapp;

public class Paciente {

    String nome;
    int idade;
    double peso;
    double altura;

public Paciente(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
}
public void exibirPaciente(){
    System.out.println("Nome: " + this.nome);
    System.out.println("Idade: " + this.idade + "anos");
    System.out.println("Peso: " + this.peso + "Kg");
    System.out.println("Altura: " + this.altura + "m");
}

}
