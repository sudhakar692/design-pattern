package tic_tac_toe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }


    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow(){
        return this.row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getCol(){
        return this.col;
    }

    public void setCellState(CellState cellState){
        this.cellState = cellState;
    }

    public CellState getCellState(){
        return cellState;
    }



}
