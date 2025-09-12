package br.com.expensecontroller.view;

import br.com.expensecontroller.enums.Categoria;
import br.com.expensecontroller.model.Gastos;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;


public class GastosView {

    @FXML private ComboBox<Categoria> categoria;
    @FXML private TextField descricao;
    @FXML private TextField custo;
    @FXML private DatePicker data;
    @FXML private Button adicionar;
    @FXML private Button remover;
    @FXML private TableView<Gastos> tabelaDespesas;
    @FXML private TableColumn<Gastos, Categoria> colCategoria;
    @FXML private TableColumn<Gastos, String> colDescricao;
    @FXML private TableColumn<Gastos, String> colCusto;
    @FXML private TableColumn<Gastos, LocalDate> colData;

    @FXML
    private void initialize(){

    }
}
