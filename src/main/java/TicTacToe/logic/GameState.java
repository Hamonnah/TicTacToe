package TicTacToe.logic;

import TicTacToe.*;

public class GameState {

    public static GameState gameState;

    private Content content;

    public static void init(Content content) {
        if (gameState == null) {
            gameState = new GameState(content);
        }
    }

    public static void newGame(Content content) {
        gameState = new GameState(content);
    }

    public static GameState getGameState() {
        return gameState;
    }

    private GameState(Content content) {
        this.content = content;
    }

    public boolean checkState() {
        for (Combo combo : new CombosList(content.getBoard().getTiles()).getCombos()) {
            if (combo.isComplete()) {
                content.playWinAnimation(combo);
                if (combo.getTile(0).getValue() == Game.Type.X) {
                    Scores.won();
                    setGameStatusFlags();
                }
                if (combo.getTile(0).getValue() == Game.Type.O) {
                    Scores.lost();
                    setGameStatusFlags();
                }
                return false;
            }

            if (!Minimax.hasFreeTiles() && !combo.isComplete()) {
                Scores.draw();
                setGameStatusFlags();
                break;
            }
        }
        return true;
    }

    public static void setGameStatusFlags() {
    }

    public Content getContent() {
        return content;
    }

}
