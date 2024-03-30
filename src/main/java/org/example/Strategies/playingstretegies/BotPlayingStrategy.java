package org.example.Strategies.playingstretegies;

import org.example.models.Board;
import org.example.models.Move;

public interface BotPlayingStrategy {

    Move makemove(Board borad);
}
