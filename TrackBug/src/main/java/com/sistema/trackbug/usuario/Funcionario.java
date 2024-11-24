package com.sistema.trackbug.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {
    Scanner inserir = new Scanner(System.in);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int codigo;
    private String nome;
    private String funcao;
    private LocalDate dataAdmissao;

    private static int contador = 1;
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();


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

    public void cadastrarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
        System.out.println("Colaborador cadastrado com sucesso!\n");

        /*System.out.println("\n\t\tCADASTRAR FUNCIONÁRIOS");
        System.out.print("Nome: ");
        String nome = inserir.nextLine();

        // Validação
        int codigo;
        boolean codigoValido = false;
        do {
            codigoValido = true;
            System.out.print("Código: ");
            codigo = inserir.nextInt();
            inserir.nextLine();

            // Verifica se o código já está cadastrado na lista
            for(Funcionario teste : listaFuncionarios) {
                if (teste.getCodigo() == codigo) {
                    System.out.println("Este código já foi cadastrado no sistema, insira um código válido!");
                    codigoValido = false;
                    break;
                }
            }
        } while(!codigoValido);

        System.out.print("Função: ");
        String funcao = inserir.nextLine();

        System.out.print("Data de Admissão (ANO-MES-DIA): ");
        LocalDate dataAdmissao = LocalDate.parse(inserir.nextLine());
        // Cria um novo objeto Funcionario e o adiciona à lista de funcionários
        Funcionario funcionario = new Funcionario(codigo, dataAdmissao, funcao, nome);
        listaFuncionarios.add(funcionario);
        System.out.println("O funcionário '" + nome + "' foi cadastrado com sucesso!\n");

         */
    }

    // Método para remover um funcionário da lista
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

    // Método para listar todos os funcionários cadastrados na lista
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
        return "FUNCIONÁRIO - " + nome + "\n\nCódigo: " + codigo + "\nNome: " + nome +
                "\nFunção: " + funcao + "\nData de admissão: " + formatado;
    }
}