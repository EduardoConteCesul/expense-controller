package br.com.expensecontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{

    // Substituir endereço
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/expensecontroller/DespesasView.fxml"));

        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Controle de Despesas  - MVVM");
        stage.show();
    }

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
    }
}
