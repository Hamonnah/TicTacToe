package TicTacToeGame;

import Controllers.MenuDesigner;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TicTacToeDrawer {

    private GameState gameState;
    private BorderPane borderPane = new BorderPane();
    private GridPane gridPane = new GridPane();
    private MenuDesigner menuDesigner = new MenuDesigner();

    public TicTacToeDrawer() {
        this.gameState = gameState;

        createBoardBackground();
        createBoardLayout();

        borderPane.setCenter(gridPane);
        borderPane.setTop(menuDesigner.getMenuBar());
    }

    private Background createBoardBackground() {
        BackgroundSize backgroundSize = new BackgroundSize(612, 612, false, false, true, false);
        Image imageBoard = new Image("table.png");
        BackgroundImage backgroundImage = new BackgroundImage(imageBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background;
        background = new Background(backgroundImage);
        return background;
    }

    private void createBoardLayout() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30,30,30,30));
        gridPane.setBackground(createBoardBackground());

        for(int i = 0; i < 8; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(496/8);
            columnConstraints.setHalignment(HPos.CENTER);
            gridPane.getColumnConstraints().add(columnConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(496/8);
            rowConstraints.setValignment(VPos.CENTER);
            gridPane.getRowConstraints().add(rowConstraints);
        }
    }

    public BorderPane getBorderPane() {
       return borderPane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

}
