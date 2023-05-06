package tic_tac_toe.strategies.bot_playing_strategy;

import tic_tac_toe.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0; i<board.getBoard().size(); i++) {
            for(int j=0; j<board.getBoard().get(i).size(); j++) {
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    return new Move(
                            player,
                            new Cell(i, j)
                    );
                }
            }
        }
        return null;
    }
}
