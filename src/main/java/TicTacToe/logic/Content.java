package TicTacToe.logic;

import TicTacToe.Game;
import TicTacToe.board.Board;
import TicTacToe.board.Tile;
import TicTacToe.logic.Combo;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Content {

    private Pane root = new Pane();
    private Board board = new Board();

    public Content() {
        createContent();
        board.createBoard();
        for (Tile[] tile : board.getTiles()) {
            for (Tile tile1 : tile) {
                getRoot().getChildren().add(tile1);
            }
        }
    }

    public Pane getRoot() {
        return root;
    }

    public void createContent() {
        Image imageBg = new Image("table.png");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBg, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        root.setPrefSize(600, 600);
        root.setBackground(background);
    }

    public void playWinAnimation(Combo combo) {
        Line line = new Line();
        line.setStrokeWidth(10);

        line.setStroke(calculateStrokeColor(combo));

        line.setStartX(combo.getTile(0).getCenterX());
        line.setStartY(combo.getTile(0).getCenterY());
        line.setEndX(combo.getTile(0).getCenterX());
        line.setEndY(combo.getTile(0).getCenterY());
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                new KeyValue(line.endXProperty(), combo.getTile(2).getCenterX()),
                new KeyValue(line.endYProperty(), combo.getTile(2).getCenterY())));
        timeLine.play();
        root.getChildren().add(line);
    }

    private Color calculateStrokeColor(Combo combo) {
        if (combo.getTile(0).getValue().equals(Game.Type.X)) {
            return Color.LIME;
        } else if (combo.getTile(0).getValue().equals(Game.Type.O)) {
            return Color.RED;
        }
        return Color.BLACK;
    }

    public Board getBoard() {
        return board;
    }

}
