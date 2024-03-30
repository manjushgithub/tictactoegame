package org.example.models;

public class Cell {

    private int row;
    private int col;
    private Player player;
    private Cellstate cellstate;

    public Cellstate getCellstate() {
        return cellstate;
    }

    public void setCellstate(Cellstate cellstate) {
        this.cellstate = cellstate;
    }

    public  Cell(int row, int col)
    {
        this.row=row;
        this.col=col;
        this.cellstate=Cellstate.empty;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
