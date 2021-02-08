package TicTacToe.logic;

import TicTacToe.Game;
import TicTacToe.board.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameAlgorithm {

    private static Content content = GameState.getGameState().getContent();
    private static Tile[][] board = content.getBoard().getTiles();

    public static List<Tile> getAvailableTiles () {
        List<Tile> availableTiles = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3; j++) {
                if (board[i][j].getValue() == Game.Type.EMPTY) {
                    availableTiles.add(board[i][j]);
                }
            }
        }
        return availableTiles;
    }

    public static boolean hasFreeTiles() {
        return !getAvailableTiles().isEmpty();
    }

    public static void setDefaultValues() {
        content = GameState.getGameState().getContent();
        board = content.getBoard().getTiles();
    }

}
