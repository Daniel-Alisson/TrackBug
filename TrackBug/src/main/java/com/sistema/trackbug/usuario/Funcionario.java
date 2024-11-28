package com.sistema.trackbug.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {
    // ATRIBIUTOS
    private int codigo;
    private String nome;
    private String funcao;
    private LocalDate dataAdmissao;
    private static int contador = 1;

    Scanner inserir = new Scanner(System.in);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // LISTA DE FUNCIONARIOS ATIVOS
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    // CONSTRUTOR
    public Funcionario(String nome, String funcao, LocalDate dataAdmissao) {
        this.codigo = contador++;
        this.dataAdmissao = dataAdmissao;
        this.funcao = funcao;
        this.nome = nome;
    }

    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        Funcionario.listaFuncionarios = listaFuncionarios;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // METODO PARA CADASTRAR FUNCIONARIOS
    public void cadastrarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
        System.out.println("Colaborador cadastrado com sucesso!\n");
    }

    public void removerFuncionario(java.util.List<Funcionario> listaFuncionarios) {
        if(listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado!\n");
            return;
        }
        System.out.println("\n\t\tREMOVER FUNCIONÁRIO");
        System.out.print("Informe o código do funcionário que deseja remover: ");
        int codigo = inserir.nextInt();
        inserir.nextLine();

        boolean achei = false;
        for(int i = 0; i < listaFuncionarios.size(); i++) {
            Funcionario funcionario = listaFuncionarios.get(i);
            if(funcionario.getCodigo() == codigo) {
                listaFuncionarios.remove(i);
                System.out.println("O Funcionário '" + funcionario.getNome() + "' foi removido com sucesso!");
                achei = true;
                break;
            }
        }
        if(!achei) {
            System.out.println("Funcionário não foi encontrado");
        }
    }

    public void listarFuncionarios(java.util.List<Funcionario> listaFuncionarios) {
        System.out.println("\n\t\tLISTAGEM DE FUNCIONÁRIOS");
        if(listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado!\n");
        } else {
            for(int i = 0; i < listaFuncionarios.size(); i++) {
                Funcionario funcionario = listaFuncionarios.get(i);
                System.out.println(funcionario);
                System.out.println("------------------------");
            }
        }
    }

    public static void listarFuncionarios() {
        for (Funcionario f : listaFuncionarios) {
            System.out.println("Código: " + f.getCodigo() + ", Nome: " + f.getNome());
        }
    }

    @Override
    public String toString() {
        String formatado = dataAdmissao.format(formato);
        return "Informações do Funcionário\n\nNome: " + nome + "\nCódigo: " + codigo + "\nFunção: " + funcao + "\nData de admissão: " + formatado;
    }
}