package com.sistema.trackbug.colaborador;

import java.util.ArrayList;
import java.util.List;

public class Colaborador implements Servicos {
    // ATRIBUTOS
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    // LISTA DE COLABORADORES
    private static List<Colaborador> listaColaboradores = new ArrayList<>();
    // TENTATIVA DE IMPLEMENTAR INFORMACOES DO COLABORADOR LOGADO
    private static Colaborador colaboradorLogado = null;

    // CONSTRUTOR
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

    // METODO PARA CADASTRAR COLABORADORES, ELE APENAS ADICIONA NA LISTA DE ADMINS

    public void cadastrarColaborador(Colaborador colaborador) {
        listaColaboradores.add(colaborador);
        System.out.println("Colaborador cadastrado com sucesso!\n");
    }

    // METODO PARA LOGAR UM ADMIN, ELE TEM UM VERIFICADOR DE EMAIL E SENHA
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

    // UM METODO PARA DESLOGAR, POSTERIORMENTE DEVO COLOCAR UM BOTÃO PARA DESLOGAR O ADMIN NO MENU PRINCIPAL
    // REVISAR
    public void deslogarColaborador() {
        System.out.println("Login desconectado!\n");
    }
}