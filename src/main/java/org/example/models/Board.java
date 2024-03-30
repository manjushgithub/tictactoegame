package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    private int size;
    private List<List<Cell>> board;
    public Board(int dimension) {
        //initialize a borad of size *size
        this.size = dimension;
        board=new ArrayList<>();

        //now we have to initialze a list
        //use for loop in java
        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                 board.get(i).add(new Cell(i,j));

            }
        }
    }

    public void displayBoard(){

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++) {
                Cell cell = board.get(i).get(j);
                if (cell.getCellstate().equals(Cellstate.empty)) {
                    System.out.print("|  |");

                } else {
                    System.out.print("|" + cell.getPlayer().getSymbol().getSymbol() + "|");

                }
            }
            System.out.println();
        }

    }


}
