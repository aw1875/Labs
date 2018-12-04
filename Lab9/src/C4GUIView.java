/**
 * file: C4GUIView.java
 * language: java
 * author: Adam Wolf
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class C4GUIView extends Application implements Observer<Move> {

    private C4Model model;
    private boolean winner;
    private GridPane board;
    private Label l1;

    /**
     * Constructor of C4GUIView
     */
    public C4GUIView() {
        this.model = new C4Model();
        this.model.register(this);
        this.winner = false;
    }

    /**
     * Create board
     * @param primaryStage
     * @throws Exception
     */
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
            bt.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (winner == false) {
                        model.makeMove(Integer.parseInt(bt.getText()));
                    }
                }
            });
        }

        // Create GridPane
        GridPane gp = new GridPane();
        this.board = gp;
        gp.setGridLinesVisible(true);

        // Populate GridPane
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                // Create Empty ImageView
                ImageView iv = new ImageView();
                iv.setFitHeight(100);
                iv.setFitWidth(100);
                iv.setImage(new Image("/"));
                gp.addRow(i, iv);
            }
        }

        // Create and Setup Label
        l1 = new Label("Player 1's turn...");
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

    /**
     * Change label text and simulate the game
     * @param pushData
     */
    public void update(Move pushData) {
        l1.setText("Player " + String.valueOf(pushData.getPlayer()) + "'s turn...");
        if (pushData.isWinner() == false) {
            addImage(board, pushData.getPlayer(), pushData.getCol(), pushData.getRow());
        } else {
            addImage(board, pushData.getPlayer(), pushData.getCol(), pushData.getRow());
            l1.setText("Player " + String.valueOf(pushData.getPlayer()) + " wins!");
            winner = true;
        }
    }

    /**
     * Add new image in correct spot
     * @param board
     * @param player
     * @param col
     * @param row
     */
    public void addImage(GridPane board, char player, int col, int row) {
        if (String.valueOf(player).equals("1")) {
            ImageView iv = new ImageView(new Image("red.png"));
            iv.setFitWidth(100);
            iv.setFitHeight(100);
            board.add(iv, col, 5 - row);
        } else {
            ImageView iv = new ImageView(new Image("black.png"));
            iv.setFitWidth(100);
            iv.setFitHeight(100);
            board.add(iv, col, 5 - row);
        }
        return;
    }

    /**
     * Call application to start game
     * @param args
     */
    public static void main (String [] args) {
        Application.launch();
    }
}
