package org.example.models;

import java.util.Scanner;

public class Player {

    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private long id;

    public Player(String name, Symbol symbol, PlayerType playerType, long id)
    {
        this.name=name;
        this.symbol=symbol;
        this.playerType=playerType;
        this.id=id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makemove(Board board)
    {
        Scanner sc=new Scanner(System.in);

        //ask the player to provide index to make move
        System.out.println("please tell the row index" );
        int rownum=sc.nextInt();
        System.out.println("please tell the col index to make a move");
        int colnum=sc.nextInt();
        return new Move(new Cell(rownum,colnum),this);


    }


}
