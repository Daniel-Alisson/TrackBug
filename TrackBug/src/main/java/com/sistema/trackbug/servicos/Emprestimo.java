package com.sistema.trackbug.servicos;

import com.sistema.trackbug.usuario.Funcionario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emprestimo {
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraRetorno;
    private Funcionario funcionario;
    private Equipamento equipamento;
    private String observacoes;
    private boolean ativo;

    private static List<Emprestimo> listaEmprestimos = new ArrayList<>();
    private static List<Emprestimo> historicoEmprestimos = new ArrayList<>();

    public Emprestimo(LocalDateTime dataHoraSaida, LocalDateTime dataHoraRetorno, Equipamento equipamento, Funcionario funcionario, String observacoes) {
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraRetorno = dataHoraRetorno;
        this.equipamento = equipamento;
        this.funcionario = funcionario;
        this.observacoes = observacoes;
        this.ativo = true;  // O empréstimo começa como ativo
    }

    public static List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public static void setListaEmprestimos(List<Emprestimo> listaEmprestimos) {
        Emprestimo.listaEmprestimos = listaEmprestimos;
    }

    public LocalDateTime getDataHoraRetorno() {
        return dataHoraRetorno;
    }

    public void setDataHoraRetorno(LocalDateTime dataHoraRetorno) {
        this.dataHoraRetorno = dataHoraRetorno;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }



    public void listarEmprestimosAtivos() {
        if (listaEmprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo foi cadastrado");
            return;
        }
        System.out.println("\n\t\tEMPRÉSTIMOS ATIVOS");
        boolean encontrouAtivos = false;

        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.isAtivo()) {
                encontrouAtivos = true;
                System.out.println("Equipamento: " + emprestimo.getEquipamento().getDescricao());
                System.out.println("Funcionário: " + emprestimo.getFuncionario().getNome());
                System.out.println("Data de Saída: " + emprestimo.getDataHoraSaida());
                System.out.println("Observações: " + emprestimo.getObservacoes());
                System.out.println("----------------------------------------");
            }
        }

        if (!encontrouAtivos) {
            System.out.println("Não há empréstimos ativos no momento");
        }
    }

    public void historicoEmprestimos() {
        if (historicoEmprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo foi registrado no histórico");
            return;
        }

        System.out.println("\n\t\tHISTÓRICO DE EMPRÉSTIMOS");

        for (Emprestimo emprestimo : historicoEmprestimos) {
            System.out.println("Equipamento: " + emprestimo.getEquipamento().getDescricao());
            System.out.println("Funcionário: " + emprestimo.getFuncionario().getNome());
            System.out.println("Data de Saída: " + emprestimo.getDataHoraSaida());

            if (emprestimo.getDataHoraRetorno() != null) {
                System.out.println("Data de Retorno: " + emprestimo.getDataHoraRetorno());
            } else {
                System.out.println("Data de Retorno: Empréstimo ainda ativo");
            }
            System.out.println("Observações: " + emprestimo.getObservacoes());
            System.out.println("----------------------------------------");
        }
    }

    @Override
    public String toString() {
        return "EMPRÉSTIMO - Equipamento: " + equipamento.getDescricao() + "\nFuncionário: " + funcionario.getNome() +
                "\nData de Saída: " + dataHoraSaida + "\nData de Retorno: " + dataHoraRetorno +
                "\nObservações: " + observacoes;
    }
}