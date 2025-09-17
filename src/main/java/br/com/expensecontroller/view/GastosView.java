package br.com.expensecontroller.view;

import br.com.expensecontroller.enums.Categoria;
import br.com.expensecontroller.model.Gastos;
import br.com.expensecontroller.view_model.GastosViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;

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
    @FXML private Label totalDespesas;

    private final GastosViewModel vm = new GastosViewModel();

    @FXML
    private void initialize(){

        categoria.getItems().setAll(Categoria.values());
        categoria.valueProperty().bindBidirectional(vm.categoriaObjectProperty());

        descricao.textProperty().bindBidirectional(vm.descricaoProperty());

        TextFormatter<Number> custoFormatter = new TextFormatter<>(new NumberStringConverter());
        custo.setTextFormatter(custoFormatter);

        data.valueProperty().bindBidirectional(vm.getData());

        Bindings.bindBidirectional(vm.valorProperty(), custoFormatter.valueProperty());

        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colCusto.setCellValueFactory(new PropertyValueFactory<>("custo"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        tabelaDespesas.setItems(vm.getDespesas());

        totalDespesas.textProperty().bind(vm.totalProperty().asString("R$ %.2f"));

        adicionar.setOnAction( actionEvent -> {
            vm.addDespesa();
        });

        remover.setOnAction(actionEvent -> {
            vm.deletarItemSelecionado(tabelaDespesas.getSelectionModel().getSelectedItem());
        });
    }
}
