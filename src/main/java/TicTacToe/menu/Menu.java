package TicTacToe.menu;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private Pane root = new Pane();

    private List<Pair<Label, Runnable>> menuData = new ArrayList<>();

    public void generate() {
        addTitle();
        root.setPrefSize(WIDTH, HEIGHT);
        root.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");

        double lineX = WIDTH / 2 - 200;
        double lineY = HEIGHT / 2 - 200;

        addMenu(lineX + 5, lineY + 5);
    }

    public void addMenuData(Pair<Label,Runnable> pair) {
        menuData.add(pair);
    }

    private void addMenu(double x, double y) {
        VBox menuBox = new VBox(-5);
        menuBox.setTranslateX(x);
        menuBox.setTranslateY(y);
        menuData.forEach(data -> {
            MenuItem item = new MenuItem(data.getKey().getText());
            Rectangle empty = new Rectangle(0,60);
            if (!data.getKey().getText().equals("")) {
                item.setOnAction(data.getValue());
                item.setTranslateX(0);
                Rectangle clip = new Rectangle(400, 50);
                clip.translateXProperty().bind(item.translateXProperty().negate());
                item.setClip(clip);
                menuBox.getChildren().addAll(item);
            } else {
                menuBox.getChildren().addAll(empty);
            }

        });

        root.getChildren().add(menuBox);
    }

    private void addTitle() {
        MenuTitle title = new MenuTitle("Tic Tac Toe");
        title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
        title.setTranslateY(HEIGHT / 3 - 130);

        root.getChildren().add(title);
    }

    public Pane getRoot() {
        return root;
    }

}
