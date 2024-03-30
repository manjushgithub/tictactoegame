package org.example.models;

import org.example.Exception.gameinvalidexception;
import org.example.Strategies.playingstretegies.Winningstrategy.winningstrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
//game has lot of attribute and few validation
    //no of player
    //should not have symbol
    //builder design pattern
    private Board board;
    private List<Player> player;
    private  GameState gamestate;
    private Player winner;
    private int nextmoveplayerindex;//which player has turn
    private List<Move> moves;
    private List<winningstrategy> winningstrategies;
    public static builder getbuilder()
    {
        return new builder();
    }

    public static class builder
    {
       private int dimension;
       private List<Player> players;
       private List<winningstrategy> winningstrategies;

       private builder()
       {
           this.players=new ArrayList<>();
           this.winningstrategies=new ArrayList<>();
           this.dimension=0;
       }


        public builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public builder setWinningstrategies(List<winningstrategy> winningstrategies) {
            this.winningstrategies = winningstrategies;
            return this;
        }
        public boolean validate()
        {
            return true;
            //only 1 bot
            //no two player have same symbol
        }
        public Game build() throws Exception {
            if(!validate())
            {
                throw new gameinvalidexception("invalid ");
            }
            //create the game object
            return new Game(dimension,players,winningstrategies);
        }


    }

    private Game(int dimension,List<Player> player,List<winningstrategy> winningstrategies)
    {
        this.board=new Board(dimension);
        this.gamestate=GameState.In_progress;
        this.nextmoveplayerindex=0;
        this.moves=new ArrayList<>();
        this.winningstrategies=winningstrategies;
        this.player=player;
    }

    //Builder pattern

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<org.example.models.Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<org.example.models.Player> player) {
        player = player;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public org.example.models.Player getWinner() {
        return winner;
    }

    public void setWinner(org.example.models.Player winner) {
        this.winner = winner;
    }

    public int getNextmoveplayerindex() {
        return nextmoveplayerindex;
    }

    public void setNextmoveplayerindex(int nextmoveplayerindex) {
        this.nextmoveplayerindex = nextmoveplayerindex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void printboard()
    {
         board.displayBoard();

    }
    public void undo()
    {

    }
    public boolean validateMove(Move move)
    {
        int row=move.getCell().getRow();
        System.out.print(row);
        int col=move.getCell().getCol();
        System.out.print(col);

        return row<board.getSize() &&row>=0&& col<getBoard().getSize()&& col>=0&&
                board.getBoard().get(row).get(col).getCellstate().equals(Cellstate.empty);

    }
    private boolean checkwinner(Move move,Board board)
    {
        for(winningstrategy winning:winningstrategies)
        {
            if(winning.checkwinner(move,board))
            {
                return true;
            }
        }
        return false;
    }


    public void makeMove(Board board)
    {
         Player currentPlayer= player.get(nextmoveplayerindex);
         System.out.println("it is " +currentPlayer.getName()+" s move.");
         Move move=currentPlayer.makemove(this.board);

         System.out.println(currentPlayer.getName()+" has made a move at time "+move.getCell().getRow()+" col " +
                 ""+move.getCell().getCol()+".");
         //validate the move its correct 1 one or not
        if(!validateMove(move))
        {
            System.out.println("invalid move taken by player "+currentPlayer.getName());

            return;
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell finalcelltomakemove=board.getBoard().get(row).get(col);
        finalcelltomakemove.setCellstate(Cellstate.filled);
        finalcelltomakemove.setPlayer(currentPlayer);
        Move finalmove=new Move(finalcelltomakemove,currentPlayer);
        moves.add(finalmove);
        nextmoveplayerindex++;
        nextmoveplayerindex%=player.size();

        //once a player has made move,check the winner
        //checkwinner method
        if(checkwinner(move,board))
        {
            gamestate=GameState.Ended;
            winner=currentPlayer;
        }
        else if(moves.size()==board.getSize()+board.getSize())
        {
            gamestate=GameState.draw;
        }
    }



}
