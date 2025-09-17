package br.com.expensecontroller.model;

import br.com.expensecontroller.enums.Categoria;
import org.bson.types.ObjectId;

import java.time.LocalDate;

// Representação em código da nossa tabela do banco

public class Gastos {

    private ObjectId id;
    private Categoria categoria;
    private String descricao;
    private double custo;
    private LocalDate data;

    public Gastos(){}

    public Gastos(Categoria categoria, String descricao, double custo, LocalDate data) {
        this.id = null;
        this.categoria = categoria;
        this.descricao = descricao;
        this.custo = custo;
        this.data = data;
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

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
