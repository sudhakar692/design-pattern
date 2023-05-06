package tic_tac_toe.controllers;

import tic_tac_toe.models.Game;
import tic_tac_toe.models.GameStatus;
import tic_tac_toe.models.Player;

import java.util.List;

public class GameController {
    public void undo(Game game) {
        game.undo();
    }

    public Game createGame(int dimension, List<Player> players) {
        try {
            return Game.getBuilder().setDimension(dimension).setPlayers(players).build();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
