package TicTacToe;

public class GameState {

    public static GameState gameState;

    private Content content;
    private static boolean win;
    private static boolean lost;
    private static boolean draw;

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
                    setGameStatusFlags(true, false, false);
                }
                if (combo.getTile(0).getValue() == Game.Type.O) {
                    Scores.lost();
                    setGameStatusFlags(false, true, false);
                }
                return false;
            }

            if (!Minimax.hasFreeTiles() && !combo.isComplete()) {
                Scores.draw();
                setGameStatusFlags(false, false, true);
                break;
            }
        }
        return true;
    }

    public static void setGameStatusFlags(boolean gameWasWon, boolean gameWasLost, boolean gameWasDraw) {
        GameState.win = gameWasWon;
        GameState.lost = gameWasLost;
        GameState.draw = gameWasDraw;
    }

    public Content getContent() {
        return content;
    }

    public static boolean isWin() {
        return win;
    }

    public static boolean isLost() {
        return lost;
    }

    public static boolean isDraw() {
        return draw;
    }

}
