package tic_tac_toe.models;

import tic_tac_toe.exceptions.InvalidGameConstructionParameterException;
import tic_tac_toe.strategies.game_winning_strategy.GameWinningStrategy;
import tic_tac_toe.strategies.game_winning_strategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    private Game() {

    }
    public Player getWinner(){
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setGameStatus(GameStatus status) {
        this.gameStatus = status;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void undo() {

    }

    public void makeNextMove() {
        Player toMovePlayer = players.get(nextPlayerIndex);
        System.out.println("It is " + toMovePlayer.getName() + "'s turn");

        Move move = toMovePlayer.decideMove(this.board);

        //validate the move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Move happend at: " + row + " " + col);

        //update board
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        Move finalMove = new Move(
                toMovePlayer,
                board.getBoard().get(row).get(col)
        );
        this.moves.add(finalMove);

        // Check the winner
        if(gameWinningStrategy.checkWinner(
                board, toMovePlayer, finalMove.getCell()
        )) {
            gameStatus = GameStatus.ENDED;
            winner = toMovePlayer;
        }

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
    }

    public void displayBoard() {
        this.board.display();
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void valid() throws InvalidGameConstructionParameterException {
            if (this.dimension < 3) {
                throw new InvalidGameConstructionParameterException("dimension of game can't be less than 3");
            }
            if (this.players.size() != this.dimension - 1) {
                throw new InvalidGameConstructionParameterException("Number of player must be dimension - 1");
            }
            // Validate no 2 people with same symbol

            // Validate that there should be only 1 bot
        }

        public Game build() throws InvalidGameConstructionParameterException {
            try {
                valid();
            } catch (InvalidGameConstructionParameterException e) {
                throw new InvalidGameConstructionParameterException(e.getMessage());
            }

            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setBoard(new Board(this.dimension));
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(this.dimension));
            game.setMoves(new ArrayList<>());

            return game;

        }


    }
}
