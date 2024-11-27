package com.sistema.trackbug.servicos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipamento {
    // ATRIBUTOS
    private int codigo;
    private String descricao;
    private LocalDate dataCompra;
    private double peso;
    private double largura;
    private double comprimento;
    private List<Manutencao> historicoManutencao;
    private String estadoConservacao;

    // LISTA DE EQUIPAMENTOS DISPONIVEIS
    private static List<Equipamento> listaEquipamentos = new ArrayList<>();
    Scanner inserir = new Scanner(System.in);
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // CONSTRUTOR
    public Equipamento(int codigo, double comprimento, LocalDate dataCompra, String descricao, String estadoConservacao, List<Manutencao> historicoManutencao, double largura, double peso) {
        this.codigo = codigo;
        this.comprimento = comprimento;
        this.dataCompra = dataCompra;
        this.descricao = descricao;
        this.estadoConservacao = estadoConservacao;
        this.historicoManutencao = historicoManutencao;
        this.largura = largura;
        this.peso = peso;
    }

    public static List<Equipamento> getListaEquipamentos() {
        return listaEquipamentos;
    }

    public static void setListaEquipamentos(List<Equipamento> listaEquipamentos) {
        Equipamento.listaEquipamentos = listaEquipamentos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public List<Manutencao> getHistoricoManutencao() {
        return historicoManutencao;
    }

    public void setHistoricoManutencao(List<Manutencao> historicoManutencao) {
        this.historicoManutencao = historicoManutencao;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // METODO PARA CADASTRAR NOVOS EQUIPAMENTOS, DA MESMA FORMA QUE OS FUNCIONARIOS, SÓ ADICIONA NA LISTA
    // PROVAVELMENTE VOU TER Q CRIAR VERIFICADORES AQ E NA CLASSE FUNCIONARIO
    public void cadastrarEquipamento(Equipamento equipamento) {
        listaEquipamentos.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso!");
    }

    // REVISAR
    public void removerEquipamento(List<Equipamento> listaEquipamentos, List<Equipamento> listaEquipamentosIndisponiveis) {
        if(listaEquipamentos.isEmpty() && listaEquipamentosIndisponiveis.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado!\n");
            return;
        }
        System.out.print("Informe o código do equipamento que deseja remover: ");
        int codigo = inserir.nextInt();
        inserir.nextLine();

        Equipamento achei = null;
        boolean estadoIndisponivel = false;

        for(int i = 0; i < listaEquipamentos.size(); i++) {
            Equipamento equipamento = listaEquipamentos.get(i);
            if (equipamento.getCodigo() == codigo) {
                achei = equipamento;
                break;
            }
        }
        // Se não encontrou na lista de disponíveis então procura na lista de indisponíveis e fé q vai ta la
        if(achei == null) {
            for(int i = 0; i < listaEquipamentosIndisponiveis.size(); i++) {
                Equipamento equipamento = listaEquipamentosIndisponiveis.get(i);
                if (equipamento.getCodigo() == codigo) {
                    achei = equipamento;
                    estadoIndisponivel = true;
                    break;
                }
            }
        }
        if(achei != null) {
            listaEquipamentos.remove(achei);
            System.out.println("Equipamento removido com sucesso!\n");
        } else {
            System.out.println("Equipamento não encontrado!\n");
        }
    }

    public void listarEquipamentos(List<Equipamento> listaEquipamentos) {
        if (listaEquipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento cadastrado.\n");
            return;
        }
        System.out.println("\n\t\tLISTA DE EQUIPAMENTOS:");
        for (int i = 0; i < listaEquipamentos.size(); i++) {
            Equipamento equipamento = listaEquipamentos.get(i);
            System.out.println("Descrição: " + equipamento.getDescricao());
            System.out.println("Código: " + equipamento.getCodigo());
            String formatado = dataCompra.format(formato);
            System.out.println("Data de Compra: " + formatado);
            System.out.println("Peso: " + equipamento.getPeso() + "kg");
            System.out.println("Largura: " + equipamento.getLargura() + "m");
            System.out.println("Comprimento: " + equipamento.getComprimento() + "m");
            System.out.println("Estado de Conservação: " + equipamento.getEstadoConservacao());
            System.out.println("------------------------------------");
        }
    }

    @Override
    public String toString() {
        String formatado = dataCompra.format(formato);
        return "EQUIPAMENTO - " + codigo + "\n\nCódigo: " + codigo + "\nComprimento: " + comprimento +
                "\nData de Compra: " + formatado + "\nDescrição: " + descricao + "\nLargura: " + largura +
                "\nPeso: " + peso + "\nEstado de Conservação: " + estadoConservacao;
    }
}
