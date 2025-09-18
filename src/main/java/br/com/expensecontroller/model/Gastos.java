package br.com.expensecontroller.model;

import br.com.expensecontroller.enums.Categoria;
import org.bson.types.ObjectId;

import java.time.LocalDate;

// Representação no código da nossa tabela do banco

public class Gastos {

    private ObjectId id;
    private Categoria categoria;
    private String descricao;
    private double valorGasto;
    private LocalDate dataGasto;

    public Gastos(){}
    public Gastos(Categoria categoria, String descricao, double valorGasto, LocalDate dataGasto) {
        this.id = null;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valorGasto = valorGasto;
        this.dataGasto = dataGasto;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public LocalDate getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(LocalDate dataGasto) {
        this.dataGasto = dataGasto;
    }
}
