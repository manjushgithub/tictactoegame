package org.example;

import org.example.Strategies.playingstretegies.EasyBotPlayingStrategy;
import org.example.Strategies.playingstretegies.Winningstrategy.Diogonalwinningstrategy;
import org.example.Strategies.playingstretegies.Winningstrategy.columnwinningstrategy;
import org.example.Strategies.playingstretegies.Winningstrategy.winningstrategy;
import org.example.controllers.GameController;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TictactoeMain {
    public static void main(String[] args) throws Exception {
        GameController gameController=new GameController();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the game dimension");
        int n=3;
        int noofplayers=n-1;
        List<Player> players=new ArrayList<>();
        players.add(new Player("manjush",new Symbol('X'), PlayerType.Human,1));
        players.add(new Bot("bot",new Symbol('O'), PlayerType.Bot,2,BotDifficultyLevel.easy, new EasyBotPlayingStrategy()));

        List<winningstrategy> winningstrategies=new ArrayList<>();
        winningstrategies.add(new columnwinningstrategy());
        winningstrategies.add(new columnwinningstrategy());
        winningstrategies.add(new Diogonalwinningstrategy());

        //start the game
       Game game= gameController.startgame(n,players,winningstrategies);

//start playing the game
        while(gameController.getgamestate(game).equals(GameState.In_progress))
        {
            System.out.println("ths is the current game of product");
            gameController.displayboard(game);
            //do you want to undo?if yes call the undo functionality wlse call the makemove
            gameController.makeMove(game);
        }
        if(gameController.getgamestate(game).equals(GameState.Ended))
        {
            System.out.println("winner is "+gameController.checkwinner(game).getName());
        }
        else
        {
            System.out.println("game has drawn");
        }
    }
}
