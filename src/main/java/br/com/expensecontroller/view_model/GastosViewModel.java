package br.com.expensecontroller.view_model;

import br.com.expensecontroller.enums.Categoria;
import br.com.expensecontroller.model.Gastos;
import br.com.expensecontroller.repository.GastosRepository;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class GastosViewModel {
    private final ObjectProperty<Categoria> categoria = new SimpleObjectProperty<>();
    private final StringProperty descricao = new SimpleStringProperty();
    private final DoubleProperty valor = new SimpleDoubleProperty();
    private final ObjectProperty<LocalDate> data = new SimpleObjectProperty<>(LocalDate.now());

    private final ObservableList<Gastos> despesas = FXCollections.observableArrayList();

    private final DoubleBinding total = new DoubleBinding() {
        {bind(despesas);}
        @Override
        protected double computeValue() {
            return despesas.stream().mapToDouble(Gastos::getCusto).sum();
        }
    };

    private final GastosRepository repository = new GastosRepository();

    public GastosViewModel(){
        despesas.addAll(repository.findAll());

        despesas.addListener((ListChangeListener<? super Gastos>) change -> {
            while (change.next()){
                if (change.wasAdded()){
                    change.getAddedSubList().forEach(repository::insert);
                }

                if (change.wasRemoved()){
                    change.getRemoved().forEach(repository::delete);
                }
            }
        });
    }

    public ObjectProperty<Categoria> categoriaObjectProperty(){
        return categoria;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public DoubleProperty valorProperty() {
        return valor;
    }

    public ObjectProperty<LocalDate> getData() {
        return data;
    }

    public ObservableList<Gastos> getDespesas() {
        return despesas;
    }

    public DoubleBinding totalProperty() {
        return total;
    }

    public void addDespesa(){
        // Regras de validação
        if (descricao.get() == null || descricao.get().isBlank()) return;
        if (categoria.get() == null) return;
        Gastos expense = new Gastos(categoria.get(), descricao.get(), valor.get(), data.get());
        despesas.add(expense);
        limpasCampos();
    }

    private void limpasCampos(){
        Platform.runLater(() -> {
            categoria.set(null);
            descricao.set("");
            valor.set(0);
            data.set(LocalDate.now());
        });
    }

    public void deletarItemSelecionado(Gastos expense){
        if (expense != null) despesas.remove(expense);
    }
}
