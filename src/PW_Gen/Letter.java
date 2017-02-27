/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PW_Gen;

/**
 *
 * @author rafael
 */
public enum Letter {
    UPPER("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    LOWER("abcdefghijklmnopqrstuvwxyz"),
    NUMBER("0123456789"),
    PUNCT("+-*/()[]{}_@#§");

    private final String letters;

    private Letter(String letters) {
        this.letters = letters;
    }

    public String get() {
        return letters;
    }
}
