package com.sistema.trackbug.servicos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manutencao {
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String descricao;
    private Equipamento equipamento;
    private boolean concluida; // Indica se a manutenção foi concluída ou não

    private List<Manutencao> listaManutencao = new ArrayList<>();

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Scanner inserir = new Scanner(System.in);
    private static List<Manutencao> historicoManutencao = new ArrayList<>();

    public Manutencao(int codigo, LocalDate dataEntrada, LocalDate dataSaida, String descricao, Equipamento equipamento) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descricao = descricao;
        this.equipamento = equipamento;
        this.concluida = false; // Inicializa a manutenção como não concluída
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void registrarManutencao(List<Equipamento> listaEquipamentos, List<Equipamento> listaEquipamentosIndisponiveis) {
        if(listaEquipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento foi cadastrado");
            return;
        }
        System.out.println("\t\tREGISTRAR MANUTENÇÃO");
        System.out.print("Informe o código do equipamento: ");
        int codigoEquipamento = inserir.nextInt();
        inserir.nextLine();

        Equipamento equipamentoSelecionado = null;

        for (Equipamento equipamento : listaEquipamentos) {
            if (equipamento.getCodigo() == codigoEquipamento) {
                equipamentoSelecionado = equipamento;
                break;
            }
        }

        if (equipamentoSelecionado == null) {
            System.out.println("Equipamento não encontrado!");
            return;
        }

        System.out.print("Informe o código da manutenção: ");
        int codigoManutencao = inserir.nextInt();
        inserir.nextLine();

        System.out.print("Informe a descrição da manutenção: ");
        String descricaoManutencao = inserir.nextLine();

        LocalDate dataEntrada = LocalDate.now();

        Manutencao novaManutencao = new Manutencao(codigoManutencao, dataEntrada, null, descricaoManutencao, equipamentoSelecionado);
        historicoManutencao.add(novaManutencao);

        equipamentoSelecionado.getHistoricoManutencao().add(novaManutencao);

        listaEquipamentos.remove(equipamentoSelecionado);
        listaEquipamentosIndisponiveis.add(equipamentoSelecionado);
        System.out.println("Manutenção registrada com sucesso!\n");

    }

    public void removerManutencao(List<Equipamento> listaEquipamentos, List<Equipamento> listaEquipamentosIndisponiveis) {
        System.out.print("Informe o código da manutenção que deseja remover: ");
        int codigo = inserir.nextInt();

        Manutencao manutencaoRemover = null;
        Equipamento equipamentoRelacionado = null;

        for (Manutencao manutencao : historicoManutencao) {
            if (manutencao.getCodigo() == codigo) {
                manutencaoRemover = manutencao;
                equipamentoRelacionado = manutencao.getEquipamento();
                break;
            }
        }

        if (manutencaoRemover != null && equipamentoRelacionado != null) {
            manutencaoRemover.setConcluida(true);
            listaEquipamentosIndisponiveis.remove(equipamentoRelacionado);
            listaEquipamentos.add(equipamentoRelacionado);
            manutencaoRemover.setDataSaida(LocalDate.now());
            System.out.println("Manutenção marcada como concluída com sucesso!\n");
        } else {
            System.out.println("Manutenção não encontrada!\n");
        }
    }

    public void historicoManutencao() {
        if (historicoManutencao.isEmpty()) {
            System.out.println("\nNenhuma manutenção foi registrada no histórico.");
            return;
        }

        System.out.println("\n\t\tHISTÓRICO DE MANUTENÇÕES");

        for (Manutencao manutencao : historicoManutencao) {
            if (manutencao.getEquipamento() != null) {
                System.out.println("Equipamento: " + manutencao.getEquipamento().getDescricao());
            } else {
                System.out.println("Equipamento: Não disponível");
            }
            System.out.println("Código: " + manutencao.getCodigo());
            String entrada = dataEntrada.format(formato);
            System.out.println("Data de Entrada: " + entrada);
            String saida = dataSaida.format(formato);
            System.out.println("Data de Saída: " + saida);
            System.out.println("Descrição: " + manutencao.getDescricao());
            System.out.println("----------------------------------------");
        }
    }
    @Override
    public String toString() {
        return "DADOS DA MANUTENÇÃO\nCódigo: " + codigo +
                "\nData de Entrada: " + dataEntrada +
                "\nData de Saída: " + dataSaida +
                "\nDescrição: " + descricao;
    }
}
