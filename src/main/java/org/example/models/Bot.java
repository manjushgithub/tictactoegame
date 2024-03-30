package org.example.models;

import org.example.Strategies.playingstretegies.BotPlayingStrategy;

public class Bot extends Player{


    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, Symbol symbol, PlayerType playerType,
               long id, BotDifficultyLevel botDifficultyLevel,
               BotPlayingStrategy botPlayingStrategy) {
        super(name, symbol, playerType, id );
        this.botDifficultyLevel=botDifficultyLevel;
         this.botPlayingStrategy=botPlayingStrategy;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makemove(Board board)    {
        //how bot will make move
        //bot will make mobe based on bot difficulty level
 Move move=botPlayingStrategy.makemove(board);

        move.setPlayer(this);
        return move;
    }


}
