package tic_tac_toe.models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    public Player(String name, char aSymbol, PlayerType playerType) {
        this.name = name;
        this.symbol = aSymbol;
        this.type = playerType;
    }

    public Move decideMove(Board board){

        Scanner in = new Scanner(System.in);
        System.out.println("Please tell the row starting from 0");
        int row = in.nextInt();

        System.out.println("Please tell the col, starting from 0");
        int col = in.nextInt();

        return new Move(this, new Cell(row, col));
    }

    public char getSymbol(){
        return this.symbol;
    }

    public String getName() { return name; }
}
