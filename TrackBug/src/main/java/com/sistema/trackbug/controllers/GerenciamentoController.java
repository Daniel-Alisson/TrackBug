package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Emprestimo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class GerenciamentoController extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral, conteudoBarra;
    private boolean barraExpandida = false;
    @FXML
    private ImageView logo;

    // CAMPOS DA TELA
    @FXML
    private ListView<String> listaEquipamentosIndisponiveis;
    @FXML
    private Label detalhesEmprestimo;
    @FXML
    private Label alerta;

    // LISTA DE EMPRESTIOMS ATIVOS
    private ObservableList<Emprestimo> emprestimosAtivos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        emprestimosAtivos.addAll(Emprestimo.getListaEmprestimos());
        listaEquipamentosIndisponiveis.setItems(FXCollections.observableArrayList(emprestimosAtivos.stream().map(emprestimo -> emprestimo.getEquipamento().getDescricao()).toList()));
        listaEquipamentosIndisponiveis.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarDetalhesEmprestimo(newValue);
            }
        });
        Image icon = new Image(Objects.requireNonNull(GerenciamentoController.class.getResourceAsStream("/com/sistema/trackbug/imagens/unifan.png")));
        logo.setImage(icon);
    }

    // METODO PARA MOSTRAR DETALHES DO EQUIPAMENTO EMPRESTADO
    private void mostrarDetalhesEmprestimo(String descricaoEquipamento) {
        Emprestimo emprestimo = emprestimosAtivos.stream().filter(e -> e.getEquipamento().getDescricao().equals(descricaoEquipamento)).findFirst().orElse(null);
        if(emprestimo != null) {
            System.out.println(emprestimo.getEquipamento().toString());  // Verifique no console se os dados estão corretos
            System.out.println(emprestimo.getFuncionario().toString());  // Verifique no console
            System.out.println("Data de Saída: " + emprestimo.getDataHoraSaida());
            detalhesEmprestimo.setText(emprestimo.toString());
                    alerta.setText("Equipamento indisponível!");
        }
    }

    // METODOS PARA CONFIGURAR A BARRA LATERAL
    @FXML
    public void alternarBarra() {
        if (barraExpandida) {
            barraLateral.setPrefWidth(50);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(false);
            conteudoBarra.setManaged(false);
            logo.setVisible(false);
            logo.setManaged(false);
        } else {
            barraLateral.setPrefWidth(200);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(true);
            conteudoBarra.setManaged(true);
            logo.setVisible(true);
            logo.setManaged(true);
        }
        barraExpandida = !barraExpandida;
    }
}
