package org.example.Strategies.playingstretegies.Winningstrategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class columnwinningstrategy implements winningstrategy{
    private HashMap<Integer, HashMap<Symbol,Integer>> colmap=new HashMap<>();

    @Override
    public boolean checkwinner(Move move, Board board) {
        int col=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!colmap.containsKey(col))
        {
            colmap.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> currentmap=colmap.get(col);
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
