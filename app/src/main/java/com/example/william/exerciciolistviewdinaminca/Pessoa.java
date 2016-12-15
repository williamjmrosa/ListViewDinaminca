package com.example.william.exerciciolistviewdinaminca;

import java.io.Serializable;

/**
 * Created by willi on 15/12/2016.
 */

public class Pessoa implements Serializable {

    private String nome;
    private String sexo;
    private int idade;
    private double altura;
    private double peso;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularIMC(){

        return peso / (altura*altura);

    }

    public String verificarEstado() {
        if (calcularIMC() < 19 && sexo.equals("Feminino")) {
            return "Você esta abaixo do Peso";
        } else if (calcularIMC() < 20 && sexo.equals("Masculino")) {
            return "Você esta abaixo do Peso";
        } else if (calcularIMC() >= 19 && calcularIMC() <= 23.9 && sexo.equals("Feminino")) {
            return "Você tem seu Peso Normal";
        } else if (calcularIMC() >= 20 && calcularIMC() <= 24.9 && sexo.equals("Masculino")) {
            return "Você tem seu Peso Normal";
        } else if (calcularIMC() >= 24 && calcularIMC() <= 28.9 && sexo.equals("Feminino")) {
            return "Você esta levemente Obeso";
        } else if (calcularIMC() >= 25 && calcularIMC() <= 29.9 && sexo.equals("Masculino")) {
            return "Você esta levemente Obeso";
        } else if (calcularIMC() >= 29 && calcularIMC() <= 38.9 && sexo.equals("Feminino")) {
            return "Você esta moderadamente Obeso";
        } else if (calcularIMC() >= 30 && calcularIMC() <= 39.9 && sexo.equals("Masculino")) {
            return "Você esta moderadamente Obeso";
        } else if (calcularIMC() < 39 && sexo.equals("Feminino")) {
            return "Você esta estremamente Obeso";
        } else {
            return "Você esta estremamente Obeso";
        }

    }
    @Override
    public String toString() {
        return "Nome: "+nome
                +"\nSexo: "+sexo
                +"\nIdade: "+idade
                +"\nAltura: "+altura
                +"\nPeso: "+peso
                +"\nSeu imc é "+calcularIMC()
                +"\n"+verificarEstado();
    }
}
