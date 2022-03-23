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
public class TicTacToe {
    private Players[][] board;
    private Players currentPlayer;

    public TicTacToe(int size, Players player) {
        this.board = new Players[size][size]; //{{Players.NONE, Players.NONE, Players.NONE},
                                    //{Players.NONE, Players.NONE, Players.NONE},
                                    //{Players.NONE, Players.NONE, Players.NONE}};
        fillBoard(size);
        this.currentPlayer = player;
    }
    
    private void fillBoard(int size) {
        for(int i =0; i<size; i++) {
            for(int j =0; j<size; j++) {
                this.board[i][j] = Players.NONE;
            }
        }
    }
    
    public void updateValue(int x, int y, Players player) {
        this.board[x][y] = player;
    }
    
    public int boardSize() {
        return this.board.length;
    }
    
    public Players getValueAtIndex(int x, int y) {
        return this.board[x][y];
    }

    public Players getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer() {
        if(this.getCurrentPlayer() == Players.X) {
            this.currentPlayer = Players.O;
        } else {
            this.currentPlayer = Players.X;
        }
    }
    
    public boolean checkIfWin(Players value) {
        // check horizontal wins
        for(int i = 0; i < this.board.length; i++) {
            int count = 0;
            for(int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j].equals(value)) {
                    count++;
                }
            }
            
            if(count == this.board[i].length) {
                return true;
            }
        }
        
        // check vertical wins
        for(int i = 0; i < this.board.length; i++) {
            int count = 0;
            for(int j = 0; j < this.board[i].length; j++) {
                if(this.board[j][i].equals(value)) {
                    count++;
                }
            }
            
            if(count == this.board[i].length) {
                return true;
            }
        }
        
        // check \
        int count = 0;
        for(int i = 0; i < this.board.length; i++) {
            if(this.board[i][i].equals(value)) {
                count++;
            }
        }
        
        if(count == this.board.length) {
            return true;
        }
        
        // check /
        count = 0;
        for(int i = 0; i < this.board.length; i++) {
            if(this.board[i][this.board.length-1-i].equals(value)) {
                count++;
            }
        }
        if(count == this.board.length) {
            return true;
            
        }
        
        return false;
        
    }
    
}
