package TicTacToe.logic;

import TicTacToe.board.Tile;

import java.util.List;

public class Computer {

    private static List<Tile> availableTiles =  Minimax.getAvailableTiles();

    public static void computerPlay() {

        if (Tile.isPlayable()) {
            for (Tile tile : availableTiles) {
                if (!tile.isSelected()) {
                    tile.playComputer();
                    break;
                }
            }
        }
    }

    public static void setDefaultValues() {
        availableTiles =  Minimax.getAvailableTiles();
    }

}

