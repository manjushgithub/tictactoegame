package org.example.Strategies.playingstretegies.Winningstrategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements winningstrategy{
    private HashMap<Integer, HashMap<Symbol,Integer>> rowmap=new HashMap<>();


    @Override
    public boolean checkwinner(Move move, Board board) {

        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!rowmap.containsKey(row))
        {
            rowmap.put(row,new HashMap<>());
        }

        Map<Symbol,Integer> currentmap=rowmap.get(row);
        if(currentmap.containsKey(symbol))
        {
            currentmap.put(symbol,currentmap.get(symbol)+1);
        }
        else {
            currentmap.put(symbol,1);
        }
        if(currentmap.get(symbol)==board.getSize())
        {
            return true;
        }
        return false;
    }
}
