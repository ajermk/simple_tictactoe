/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author ana
 */

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class TicTacToeView {
    private TicTacToe game;
    private Button[][] buttons;

    public TicTacToeView(TicTacToe game) {
        this.game = game;
        // store buttons in array
        this.buttons = new Button[this.game.boardSize()][this.game.boardSize()];
        
    }
    
    public Parent getView() {
        BorderPane mainlayout = new BorderPane();
        GridPane layout = new GridPane();
        
        Label labelTurn = new Label("Turn: ");
        Label turn = new Label(this.game.getCurrentPlayer().label);
        HBox hboxTurn = new HBox();
        hboxTurn.setPadding(new Insets(10,10,10,10));
        hboxTurn.setSpacing(10);
        hboxTurn.setAlignment(Pos.CENTER);
        hboxTurn.getChildren().addAll(labelTurn, turn);
        mainlayout.setTop(hboxTurn);
        
        
        for(int i = 0; i < this.game.boardSize(); i++) {
            for(int j = 0; j < this.game.boardSize(); j++) {
                this.buttons[i][j] = new Button(this.game.getValueAtIndex(i, j).label);
                this.buttons[i][j].setFont(Font.font("Monospaced",40));
                layout.add(this.buttons[i][j], i, j);
                final int x = i;
                final int y = j;
                this.buttons[i][j].setOnMouseClicked((event) -> {
                    updateTurn(hboxTurn, turn, x, y);
                });
            }
        }
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        mainlayout.setCenter(layout);
        
        return mainlayout;
    }
    
    
    private void updateTurn(HBox hboxTurn, Label turn, int x, int y) {
        // update button
        this.buttons[x][y].setText(this.game.getCurrentPlayer().label);
        this.buttons[x][y].setDisable(true);
        this.game.updateValue(x, y, this.game.getCurrentPlayer());
        
        // check win state
        if(this.game.checkIfWin(this.game.getCurrentPlayer())) {
            hboxTurn.getChildren().clear();
            hboxTurn.getChildren().add(new Label(this.game.getCurrentPlayer().label + " wins!"));
            disableAllButtons();
        }
        
        // give turn to next player
        this.game.setCurrentPlayer();
    }
    
    private void disableAllButtons() {
        for(int i = 0; i < this.game.boardSize(); i++) {
            for(int j = 0; j < this.game.boardSize(); j++) {
                
                this.buttons[i][j].setDisable(true); 
            }
            
        }
    }
    
}
