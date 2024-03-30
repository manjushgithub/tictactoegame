package org.example.controllers;

import org.example.Strategies.playingstretegies.Winningstrategy.winningstrategy;
import org.example.models.Game;
import org.example.models.GameState;
import org.example.models.Player;

import java.util.List;

public class GameController {
    //start the game
    public Game startgame(int boarddimension, List<Player> players
    , List<winningstrategy> winningstrategies) throws Exception {

        return Game.getbuilder().setDimension(boarddimension)
                .setPlayers(players).setWinningstrategies(winningstrategies).build();
    }

    //make the move
    public void makeMove(Game game)
    {
      game.makeMove(game.getBoard());
    }
   //display the board
    public void displayboard(Game game)
    {

        game.printboard();

    }
    //check the winner
    public Player checkwinner(Game game)
    {
        return game.getWinner();
    }

    public void undo(Game game)
    {
game.undo();

    }
    public GameState getgamestate(Game game) {
        return game.getGamestate();
    }





}
