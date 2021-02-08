package TicTacToe.logic;

import TicTacToe.Game;

public class GameState {

    public static GameState gameState;

    private Content content;
    private static boolean lost;

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
                    WonGame.won();
                    setGameStatusFlags(false);
                }
                return false;
            }
        }
        return true;
    }

    public static void setGameStatusFlags(boolean gameWasLost) {
        GameState.lost = gameWasLost;
    }

    public Content getContent() {
        return content;
    }

    public static boolean isLost() {
        return lost;
    }

}
