package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.servicos.Manutencao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoController extends TrocarTelasController {
    @FXML
    TextField campoCodigo, campoDescricao, campoPeso, campoLargura, campoEstadoConservacao, campoComprimento;

    @FXML
    DatePicker campoData;

    @FXML
    Label alerta;

    @FXML
    private VBox barraLateral;

    @FXML
    private VBox conteudoBarra;

    @FXML
    private Button botaoPrincial;

    private boolean barraExpandida = false;

    @FXML
    private void cadastrarEquipamento() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            String descricao = campoDescricao.getText();
            LocalDate dataCompra = campoData.getValue();
            double peso = Double.parseDouble(campoPeso.getText());
            double largura = Double.parseDouble(campoLargura.getText());
            double comprimento = Double.parseDouble(campoComprimento.getText());
            String estadoConservacao = campoEstadoConservacao.getText();

            List<Manutencao> historicoManutencao = new ArrayList<>();

            Equipamento novoEquipamento = new Equipamento(codigo, comprimento, dataCompra, descricao, estadoConservacao, historicoManutencao, largura, peso);
            novoEquipamento.cadastrarEquipamento(novoEquipamento);
            alerta.setText("Equipamento cadastrado com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            alerta.setText("Insira valores válidos nos campos numericos");
        }
    }

    @FXML
    private void limparCampos() {
        campoCodigo.clear();
        campoDescricao.clear();
        campoData.setValue(null);
        campoPeso.clear();
        campoLargura.clear();
        campoComprimento.clear();
        campoEstadoConservacao.clear();
    }

    @FXML
    public void alternarBarra() {
        if (barraExpandida) {
            barraLateral.setPrefWidth(50);
            botaoPrincial.setText("☰");
            conteudoBarra.setVisible(false);
            conteudoBarra.setManaged(false);
        } else {
            barraLateral.setPrefWidth(200);
            botaoPrincial.setText("☰");
            conteudoBarra.setVisible(true);
            conteudoBarra.setManaged(true);
        }
        barraExpandida = !barraExpandida;
    }
}
