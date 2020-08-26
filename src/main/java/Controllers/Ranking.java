package Controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Date;

public class Ranking {

    private ArrayList<Integer> ranking = new java.util.ArrayList<>();
    private ArrayList<Integer> rankingTemp = new ArrayList<>();
    private Date date = new Date();

    private int xSWins = 0;
    private int oSWins = 0;
    private int draws = 0;
    private String dateLastGame = "";

    public void showRanking() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Ranking");
        alert.setContentText("Xs Player Wins: " + xSWins +
                "\nOs Player Wins: " + oSWins +
                "\nDraws: " + draws +
                "\n\nLast game: " + dateLastGame);

        ButtonType ok = new ButtonType("OK");
        ButtonType clear = new ButtonType("Clear");

        alert.getButtonTypes().setAll(clear, ok);

        if(alert.showAndWait().get() == clear) {
            xSWins = 0;
            oSWins = 0;
            draws = 0;
        }
    }


    public void setxSWins(int xSWins) {
        this.xSWins = xSWins;
    }

    public void setoSWins(int oSWins) {
        this.oSWins = oSWins;
    }

    public void setDraws() {
        draws++;
    }

}
