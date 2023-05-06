package tic_tac_toe.models;

import tic_tac_toe.factories.BotPlayingStrategyFactory;
import tic_tac_toe.strategies.bot_playing_strategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public Bot(String name, char aSymbol, BotDifficultyLevel difficultyLevel) {
        super(name, aSymbol, PlayerType.BOT);
        this.botDifficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(difficultyLevel);

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return  this.botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {

        return botPlayingStrategy.decideMove(this, board);
    }


}
