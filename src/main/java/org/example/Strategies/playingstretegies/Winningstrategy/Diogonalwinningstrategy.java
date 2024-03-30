package org.example.Strategies.playingstretegies.Winningstrategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class Diogonalwinningstrategy implements winningstrategy{
    private Map<Symbol,Integer> leftdiagonal=new HashMap<>();
    private Map<Symbol,Integer>  rightdiagonal=new HashMap<>();

    @Override
    public boolean checkwinner(Move move, Board board) {

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        if(row==col)
        {
            //cell present on left diogonal
            if(leftdiagonal.containsKey(symbol))
            {
                leftdiagonal.put(symbol,leftdiagonal.get(symbol)+1);
            }
            else
            {
                leftdiagonal.put(symbol,1);
            }
        }
        if(row+col==board.getSize()-1)
        {
            //cell present on right diogonal
            if(rightdiagonal.containsKey(symbol))
            {
                rightdiagonal.put(symbol,rightdiagonal.get(symbol)+1);
            }
            else
            {
                rightdiagonal.put(symbol,1);
            }
        }
        if(row==col && leftdiagonal.get(symbol)==board.getSize())
        {
            return true;
        }
        if(row+col==board.getSize()-1 && rightdiagonal.get(symbol)==board.getSize())
        {
            return true;
        }
        return false;
    }
}
