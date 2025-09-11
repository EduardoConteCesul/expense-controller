package br.com.expensecontroller.repository;

import br.com.expensecontroller.config.MongoConfig;
import br.com.expensecontroller.model.Gastos;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GastosRepository {

    private final MongoCollection<Gastos> collection =
            MongoConfig.db.getCollection("gastos", Gastos.class);

    public ObservableList<Gastos> findAll(){
        var list = FXCollections.<Gastos>observableArrayList();
        collection.find().forEach(list::add);
        return list;
    }

    public void insert(Gastos e){
        collection.insertOne(e);
    }

    public void delete(Gastos e){
        collection.deleteOne(Filters.eq("_id", e.getId()));
    }
}
