package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.servicos.Manutencao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipamentoController extends ConfigController {
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
    private TextField campoCodigo, campoDescricao, campoPeso, campoLargura, campoEstadoConservacao, campoComprimento;
    @FXML
    private DatePicker campoData;
    @FXML
    private Label alerta;
    @FXML
    private Button botaoCadastro;

    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        configBotoes(botaoCadastro);
        Image icon = new Image(Objects.requireNonNull(EquipamentoController.class.getResourceAsStream("/com/sistema/trackbug/imagens/unifan.png")));
        logo.setImage(icon);
    }

    // METODO PARA CADASTRAR EQUIPAMENTOS
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

    // METODO PARA LIMPAR CAMPOS
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

    // METODO PARA CONFIGURAR A BARRA LATERAL
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
