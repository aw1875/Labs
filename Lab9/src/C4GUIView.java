import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;

public class C4GUIView extends Application implements Observer<Move> {

    private C4Model model;
    private boolean winner;

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    public C4GUIView() {
        this.model = new C4Model();
        this.model.register(this);
        this.winner = false;
    }

    public void start(Stage primaryStage) throws Exception {
        // Create BorderPane
        BorderPane bp = new BorderPane();

        // Create TilePane
        TilePane tp = new TilePane();

        // Create buttons
        for (int i = 0; i < 7; i++) {
            Button bt = new Button();
            bt.setText(String.valueOf(i));
            bt.setMinSize(100, 40);
            bt.setMaxSize(100, 40);
            tp.getChildren().add(bt);
        }

        // Create GridPane
        GridPane gp = new GridPane();
        gp.setGridLinesVisible(true);

        // Populate GridPane
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                // Create Empty ImageView
                ImageView iv = new ImageView();
                iv.setFitHeight(100);
                iv.setFitWidth(100);
                iv.setImage(new Image("imgs/"));
                gp.addRow(i, iv);
            }
        }


        // Create and Setup Label
        Label l1 = new Label("Player 1's turn...");
        l1.setFont(new Font("Verdana", 15));

        // Create and Setup ToolBar
        ToolBar tb = new ToolBar();
        tb.getItems().add(l1);

        // Add Setup BorderPane
        bp.setTop(tp);
        bp.setCenter(gp);
        bp.setBottom(tb);

        // Setup Scene
        Scene s1 = new Scene(bp);

        // Setup Stage
        primaryStage.setScene(s1);
        primaryStage.setHeight(700);
        primaryStage.setWidth(700);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void update(Move pushData) {

    }

    public void putPiece(int column) {
        System.out.println("Put piece at " + column);

    }

}
