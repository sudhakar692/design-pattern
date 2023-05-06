package tic_tac_toe.strategies.bot_playing_strategy;

import tic_tac_toe.models.Board;
import tic_tac_toe.models.Move;
import tic_tac_toe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);


}
