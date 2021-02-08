package TicTacToe.board;

import TicTacToe.logic.Computer;
import TicTacToe.Game;
import TicTacToe.logic.GameState;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {

    private static boolean turnX = true;
    private static boolean computerTurn = false;
    private static boolean playable = true;
    private boolean isSelected = false;
    private final ImageView imageX = new ImageView(new Image("x-small.png"));
    private final ImageView imageO = new ImageView(new Image("o-small.png"));
    private Game.Type value;

    public Tile() {
        Rectangle border = new Rectangle(170, 180);
        border.setFill(null);
        border.setStroke(Color.WHITE);
        border.setVisible(false);

        setAlignment(Pos.CENTER);
        getChildren().add(border);
        value = Game.Type.EMPTY;
        onClick();
    }

    private void onClick() {
        setOnMouseClicked(event -> {
            if (isSelected || !playable)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {
                if (!turnX)
                    return;
                drawX();
                turnX = false;
                computerTurn = true;
                playable = GameState.getGameState().checkState();
                Computer.computerPlay();

            }
            else if (event.getButton() == MouseButton.SECONDARY) {
                if (turnX)
                    return;
                drawO();
                turnX = true;
                playable = GameState.getGameState().checkState();
            }
        });
    }

    public void playComputer() {
        if (computerTurn) {
            if (turnX)
                return;
            drawO();
            turnX = true;
            playable = GameState.getGameState().checkState();
            isSelected = true;
            computerTurn = false;
        }
    }

    public Game.Type getValue() {
        return value;
    }

    public double getCenterX() {
        return getTranslateX() + 85;
    }

    public double getCenterY() {
        return getTranslateY() + 90;
    }

    public void setX() {
    }

    public void setY() {
    }

    public boolean isSelected() {
        return isSelected;
    }

    public static boolean isPlayable() {
        return playable;
    }

    public void drawX() {
        getChildren().add(imageX);
        value = Game.Type.X;
        isSelected = true;
    }

    public void drawO() {
        getChildren().add(imageO);
        value = Game.Type.O;
        isSelected = true;
    }

    public static void setDefaultValues() {
        turnX = true;
        computerTurn = false;
        playable = true;
    }

}
