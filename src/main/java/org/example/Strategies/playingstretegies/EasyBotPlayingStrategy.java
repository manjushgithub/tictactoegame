package org.example.Strategies.playingstretegies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Cellstate;
import org.example.models.Move;

public class EasyBotPlayingStrategy implements  BotPlayingStrategy{

    @Override
    public Move makemove(Board board) {

      //  in easy bot playing strategy, but will make a move at frst avaialble index

        for(int i=0;i<board.getSize();i++)
        {
            for(int j=0;j< board.getSize();j++)
            {
                Cell cell=board.getBoard().get(i).get(j);
                if(cell.getCellstate().equals(Cellstate.empty))
                {
                    //make a move
                    return new Move(cell,null);
                }
            }
        }

        return null;
    }
}
