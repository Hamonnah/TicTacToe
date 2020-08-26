import TicTacToeGame.GameState;
import TicTacToeGame.TicTacToeDrawer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    GameState gameState = new GameState();
    private static Stage primaryStage = new Stage();
    TicTacToeDrawer ticTacToeDrawer = new TicTacToeDrawer();

    @Override
    public void start(Stage primaryStage) {

       // gameState.;
        this.primaryStage = primaryStage;

        Scene scene = new Scene(ticTacToeDrawer.getBorderPane(), 700, 700, Color.BLACK);

        primaryStage.setTitle("TicTacToe Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
