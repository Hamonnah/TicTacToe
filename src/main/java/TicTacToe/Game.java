package TicTacToe;

import TicTacToe.board.Tile;
import TicTacToe.logic.*;
import TicTacToe.menu.Menu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Game extends Application {

    private Content content = new Content();
    private Menu menu = new Menu();
    private Menu scores = new Menu();

    private Scene menuScene = new Scene(menu.getRoot());
    private Scene gameScene = new Scene(content.getRoot());
    private Scene scoreScene = new Scene(scores.getRoot());

    private Button btnBackToMenu = new Button("MENU");

    @Override
    public void start(Stage primaryStage) {
        GameState.init(content);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);

        createMainMenu(primaryStage);

        btnBackToMenu.setOnAction(e -> primaryStage.setScene(menuScene));
        content.getRoot().getChildren().add(btnBackToMenu);

        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void createMainMenu(Stage primaryStage) {

        menu.addMenuData(new Pair<>(new Label("New Game"), () -> {
            createNewContent();
            primaryStage.setScene(gameScene);
        }
        ));

        menu.addMenuData(new Pair<>(new Label("Close Menu"), () -> primaryStage.setScene(gameScene)));
        menu.addMenuData(new Pair<>(new Label("Quite Game"), Platform::exit));

        menu.generate();
        menu.getRoot().getChildren();
    }

    private void createNewContent() {
        content = new Content();
        GameState.newGame(content);
        Tile.setDefaultValues();
        CombosList.setDefaultValues();
        Minimax.setDefaultValues();
        Computer.setDefaultValues();
        gameScene = new Scene(content.getRoot());
        content.getRoot().getChildren().add(btnBackToMenu);
    }

    public enum Type {
        X, O, EMPTY
    }

    public static void main(String[] args) {
        launch(args);
    }

}
