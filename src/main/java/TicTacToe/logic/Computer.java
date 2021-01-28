package TicTacToe.logic;

import TicTacToe.Game;
import TicTacToe.board.Tile;

import java.util.List;

public class Computer {

    private static List<Tile> availableTiles =  Minimax.getAvailableTiles();

    public static void computerPlay() {

        if (Minimax.hasFreeTiles()) {
            Minimax.minimax(0, Game.Type.O);
            Minimax.getComputerMove().playComputer();
        }
    }

    public static void setDefaultValues() {
        availableTiles =  Minimax.getAvailableTiles();
    }

}

