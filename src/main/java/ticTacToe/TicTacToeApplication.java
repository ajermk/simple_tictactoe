package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {

    private TicTacToe game;
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        int BOARDSIZE = 7;
        
        HBox buttons = new HBox();
        Button startGameX = new Button("Start game as X");
        Button startGameO = new Button("Start game as O");
        
        buttons.getChildren().addAll(startGameX, startGameO);
        buttons.setPadding(new Insets(10,10,10,10));
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);
        
        layout.setTop(buttons);
        
        startGameX.setOnAction((event) -> {
            layout.setCenter(new TicTacToeView(new TicTacToe(BOARDSIZE, Players.X)).getView());
        });
        
        startGameO.setOnAction((event) -> {
            layout.setCenter(new TicTacToeView(new TicTacToe(BOARDSIZE, Players.O)).getView());
        });
        
        Scene scene = new Scene(layout, 400, 300);
        
        window.setScene(scene);
        window.show();
    }
}
