package org.example.Strategies.playingstretegies.Winningstrategy;

import org.example.models.Board;
import org.example.models.Move;

public interface winningstrategy {
    boolean checkwinner(Move move, Board board);
}
