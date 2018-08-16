package accounts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/accounts/accounts.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene=new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        primaryStage.centerOnScreen();


        //primaryStage.setScene(new Scene(root));
        primaryStage.setScene(scene);
        primaryStage.show();
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
