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
public enum Players {
    
    NONE(" "),
    X("X"),
    O("0");
    
    public final String label;
    
    private Players(String label) {
        this.label = label;
    }
}
