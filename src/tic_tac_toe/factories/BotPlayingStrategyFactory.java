package tic_tac_toe.factories;

import tic_tac_toe.models.BotDifficultyLevel;
import tic_tac_toe.strategies.bot_playing_strategy.BotPlayingStrategy;
import tic_tac_toe.strategies.bot_playing_strategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        return new RandomBotPlayingStrategy();
    }
}
