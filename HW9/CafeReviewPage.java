import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a JavaFX program that takes in reviews for a cafe.
 * @author Rahul
 * @version 1.0
 */
public class CafeReviewPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox(2);
        VBox vBox = new VBox();
        Button post = new Button("Post");
        TextField x = new TextField();
        x.setPromptText("name");
        TextField y = new TextField();
        y.setPromptText("feedback");
        TextField z = new TextField();
        z.setPromptText("color");
        TextField a = new TextField();
        a.setPromptText("Font weight");
        hBox.getChildren().addAll(x, y, z, a, post);
        pane.setCenter(vBox);
        pane.setBottom(hBox);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNIFIED);
        post.setOnAction(e -> {
            String name, feedback;
            Color color;
            FontWeight fontWeight;
            if (x.getText().isEmpty()) {
                name = "Anonymous:";
            } else {
                name = x.getText() + ":";
                x.clear();
            }
            if (y.getText().isEmpty()) {
                return;
            } else {
                feedback = y.getText();
                y.clear();
            }

            Text text1 = new Text(name);
            Text text2 = new Text(feedback);
            try {
                if (!z.getText().isEmpty()) {
                    color = Color.valueOf(z.getText());
                    z.clear();
                } else {
                    color = Color.BLACK;
                    z.clear();
                }
            } catch (IllegalArgumentException exp) {
                color = Color.BLACK;
                z.clear();
            }
            try {
                if (!a.getText().isEmpty()) {
                    fontWeight = FontWeight.valueOf(a.getText());
                    a.clear();
                } else {
                    fontWeight = FontWeight.NORMAL;
                    a.clear();
                }
            } catch (IllegalArgumentException s) {
                fontWeight = FontWeight.NORMAL;
                a.clear();
            }
            text1.setFont(Font.font("Verdana", fontWeight, 15));
            text2.setFont(Font.font("Verdana", fontWeight, 15));
            text1.setFill(color);
            text2.setFill(color);
            vBox.getChildren().addAll(text1, text2);
        });
        Scene scene = new Scene(pane, 690, 700);
        primaryStage.setTitle("Cafe1331 Reviews");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    /**
     * Executes the main execution of the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
