package tic_tac_toe.strategies.game_winning_strategy;

import tic_tac_toe.models.Board;
import tic_tac_toe.models.Cell;
import tic_tac_toe.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player lastMovePlayer, Cell moveCell);
}
