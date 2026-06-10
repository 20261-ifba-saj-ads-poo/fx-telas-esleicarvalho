package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.model.Carrinho;
import br.edu.ifba.saj.ads.poo.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private BorderPane pane;

    @FXML
    private TabPane tabPane;

    @FXML
    private Button btAddCarrinhoMasc;
    @FXML
    private Button btAddCarrinhoFem;
    @FXML
    private Button btAddCarrinhoInf;
    @FXML
    private Button btRemoverCarrinho;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView<Produto> tabelaMasculino;
    @FXML
    private TableColumn<Produto, String> colMasculinoNome, colMasculinoTamanho, colMasculinoCor;
    @FXML
    private TableColumn<Produto, Double> colMasculinoPreco;

    @FXML
    private TableView<Produto> tabelaFeminino;
    @FXML
    private TableColumn<Produto, String> colFemininoNome, colFemininoTamanho, colFemininoCor;
    @FXML
    private TableColumn<Produto, Double> colFemininoPreco;

    @FXML
    private TableView<Produto> tabelaInfantil;
    @FXML
    private TableColumn<Produto, String> colInfantilNome, colInfantilTamanho, colInfantilCor;
    @FXML
    private TableColumn<Produto, Double> colInfantilPreco;

    @FXML
    private TableView<Produto> tabelaCarrinho;
    @FXML
    private TableColumn<Produto, String> colCarrinhoNome, colCarrinhoTamanho, colCarrinhoCor, colCarrinhoDepartamento;
    @FXML
    private TableColumn<Produto, Double> colCarrinhoPreco;

    private Carrinho carrinho = new Carrinho();
    private ObservableList<Produto> listaCarrinho = FXCollections.observableArrayList();

    public void initialize() {
        colMasculinoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMasculinoTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colMasculinoCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colMasculinoPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        colFemininoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colFemininoTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colFemininoCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colFemininoPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        colInfantilNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colInfantilTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colInfantilCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colInfantilPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        colCarrinhoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCarrinhoTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colCarrinhoCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colCarrinhoPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colCarrinhoDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

        tabelaMasculino.setItems(FXCollections.observableArrayList(
                new Produto("Camiseta", "M", "Preto", 49.90, "Masculino"),
                new Produto("Calça", "G", "Rosa", 99.99, "Masculino"),
                new Produto("Bermuda", "GG", "Azul", 79.90, "Masculino"),
                new Produto("Camiseta", "P", "Preto", 45.90, "Masculino"),
                new Produto("Short", "M", "Preto", 40.50, "Masculino"),
                new Produto("Blusa de Frio", "P", "Verde", 129.90, "Masculino")));

        tabelaFeminino.setItems(FXCollections.observableArrayList(
                new Produto("Camiseta", "M", "Preto", 49.90, "Feminino"),
                new Produto("Jaqueta", "G", "Marrom", 169.99, "Feminino"),
                new Produto("Saia", "GG", "Azul", 79.90, "Feminino"),
                new Produto("Calça", "P", "Preto", 115.90, "Feminino"),
                new Produto("Short", "M", "Preto", 40.50, "Feminino"),
                new Produto("Vestido", "P", "Lilás", 129.90, "Feminino")));

        tabelaInfantil.setItems(FXCollections.observableArrayList(
                new Produto("Camiseta", "M", "Preto", 39.90, "Infantil"),
                new Produto("Saia", "G", "Azul", 79.90, "Infantil"),
                new Produto("Jaqueta", "G", "Marrom", 90.99, "Infantil"),
                new Produto("Vestido", "P", "Rosa", 109.90, "Infantil"),        
                new Produto("Calça", "P", "Preto", 95.90, "Infantil"),
                new Produto("Short", "M", "Amarelo", 40.50, "Infantil")));

        tabelaCarrinho.setItems(listaCarrinho);
    }

    @FXML
    public void adicionarAoCarrinho() {

        Tab abaSelecionada = tabPane.getSelectionModel().getSelectedItem();
        Produto produto = null;

        if (abaSelecionada.getText().equals("Masculino")) {
            produto = tabelaMasculino.getSelectionModel().getSelectedItem();
        }
        if (abaSelecionada.getText().equals("Feminino")) {
            produto = tabelaFeminino.getSelectionModel().getSelectedItem();
        }
        if (abaSelecionada.getText().equals("Infantil")) {
            produto = tabelaInfantil.getSelectionModel().getSelectedItem();
        }

        if (produto != null) {
            carrinho.adicionarProduto(produto);
            listaCarrinho.add(produto);
            atualizarTotal();        }
    }

    @FXML
    public void removeCarrinho() {

        Produto produto = tabelaCarrinho.getSelectionModel().getSelectedItem();

        if (produto != null) {
            carrinho.removerProduto(produto);
            listaCarrinho.remove(produto);
            atualizarTotal();
        }
    }

    public void atualizarTotal() {
        lblTotal.setText(String.format("Total: R$ %.2f", carrinho.getSoma()));
    }
}
