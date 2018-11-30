import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class C4GUIView extends Application implements Observer<Move> {

    private C4Model model;
    private boolean winner;

    public C4GUIView() {
        this.model = new C4Model();
        this.model.register(this);
        this.winner = false;
    }

    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Label l1 = new Label("Welcome to CS2");
        l1.setFont(new Font("Verdana", 30));

        bp.setCenter(l1);
        bp.setPadding(new Insets(50,20,50,20));
        Scene s1 = new Scene(bp);
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public void update(Move pushData) {

    }

}
