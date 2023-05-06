package tic_tac_toe;

import tic_tac_toe.controllers.GameController;
import tic_tac_toe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("What should be the dimension of the game?");
        int dimension = sc.nextInt();

        System.out.println("Will there be a bot in the game? y/n");
        String isBotString = sc.next();

        List<Player> players = new ArrayList<>();
        int toIterate = dimension - 1;

        if (isBotString.equals("y")) {
            toIterate = dimension - 2;
        }

        for(int i=0; i<toIterate; i++) {
            System.out.println("What is the name of the player?" + i);
            String playerName = sc.next();

            System.out.println("What is the symbol for this player" + i);
            char playerSymbol = sc.next().charAt(0);

            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if(isBotString.equals("y")) {
            System.out.println("What is the name of the bot? ");
            String botName = sc.next();

            System.out.println("What is the symbol for this bot");
            char botSymbol = sc.next().charAt(0);

            players.add(new Bot(botName, botSymbol, BotDifficultyLevel.EASY));
        }

        Game game = gameController.createGame(dimension, players);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is your current board");
            gameController.displayBoard(game);

            System.out.println("Does anyone want to undo? y/n");
            String input = sc.next();

            if (input.equals("y")) {
                gameController.undo(game);
            } else {
                gameController.executeNextMove(game);
            }
        }

        System.out.println("Game has ended, Result was: ");
        if(!game.getGameStatus().equals(GameStatus.DRAW)) {
            System.out.println("Winner is: " + gameController.getWinner(game).getName());
            gameController.displayBoard(game);
        }

    }
}
