package com.sistema.trackbug.colaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colaborador {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    private static List<Colaborador> listaColaboradores = new ArrayList<>();
    private static Colaborador colaboradorLogado = null;

    public Colaborador(String nome, String cpf, String email, String senha) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public static Colaborador getColaboradorLogado() {
        return colaboradorLogado;
    }

    public static void setColaboradorLogado(Colaborador colaboradorLogado) {
        Colaborador.colaboradorLogado = colaboradorLogado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void cadastrarColaborador(Colaborador colaborador) {
        listaColaboradores.add(colaborador);
        System.out.println("Colaborador cadastrado com sucesso!\n");
    }

    public static boolean loginColaborador(String email, String senha) {
        for(Colaborador teste : listaColaboradores) {
            if(teste.getEmail().equals(email) && teste.getSenha().equals(senha)) {
                colaboradorLogado = teste;
                System.out.println("Login feito com sucesso!\n");
                return true;
            }
        }
        System.out.println("Email ou senha inválido!\n");
        return false;
    }

    public void deslogarColaborador () {
        System.out.println("Login desconectado!\n");
    }
}