package TicTacToe.logic;

import TicTacToe.board.Tile;

import java.util.List;
import java.util.Random;

public class Computer {

    private static List<Tile> availableTiles =  FreeTilesChecker.getAvailableTiles();
    private static Random random = new Random();

    public static void computerPlay() {

        if (Tile.isPlayable()) {
            setDefaultValues();
            int freeTiles = availableTiles.size();
            int selectedTile = random.nextInt(freeTiles);
            availableTiles.get(selectedTile).playComputer();
        }
    }

    public static void setDefaultValues() {
        availableTiles =  FreeTilesChecker.getAvailableTiles();
    }

}

