package com.samuel;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    private ContaBanco conta = new ContaBanco();

    @FXML private TextField txtTitular;
    @FXML private TextField txtValor;
    @FXML private ChoiceBox<String> choiceTipo;
    @FXML private TextArea txtDetalhes;

    @FXML
    public void initialize() {
    choiceTipo.getItems().addAll(
        "Conta Corrente (CC)",
        "Conta Poupança (CP)"
    );
}


private void mostrarErro(String msg) {
    txtDetalhes.setText("❌ " + msg);
}


private float lerValor() {

    String input = txtValor.getText();

    if (input == null || input.isBlank()) {
        throw new IllegalArgumentException("Digite um valor");
    }

    input = input.replace(",", ".");

    try {
        return Float.parseFloat(input);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Valor inválido");
    }
}


    @FXML
    
    public void abrirConta() {

    try {
        String titular = txtTitular.getText();
        String tipoSelecionado = choiceTipo.getValue();

        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Digite um nome válido");
        }

        if (tipoSelecionado == null) {
            throw new IllegalArgumentException("Selecione o tipo de conta");
        }

        String tipo = tipoSelecionado.contains("Corrente") ? "CC" : "CP";

        conta.criarConta(titular, tipo);

        txtDetalhes.setText("Conta criada com sucesso!");

    } catch (Exception e) {
        mostrarErro(e.getMessage());
    }
}

    @FXML

    public void depositar() {
    try {
        float valor = lerValor();
        conta.depositar(valor);

        txtDetalhes.setText("Depósito de R$" + valor + " realizado!");

    } catch (Exception e) {
        mostrarErro(e.getMessage());
    }
}

    @FXML
    public void sacar() {
    try {
        float valor = lerValor();
        conta.sacar(valor);

        txtDetalhes.setText("Saque de R$" + valor + " realizado!");

    } catch (Exception e) {
        mostrarErro(e.getMessage());
    }
}

    @FXML
    public void exibirDados() {
    try {
        txtDetalhes.setText(conta.exibirDetalhes());
    } catch (Exception e) {
        mostrarErro(e.getMessage());
    }
}

    @FXML
    public void fecharConta() {
    try {
        conta.fecharConta();
        txtDetalhes.setText("Conta fechada!");
    } catch (Exception e) {
        mostrarErro(e.getMessage());
    }
}
}
