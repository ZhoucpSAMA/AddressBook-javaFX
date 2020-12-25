import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent parent =  FXMLLoader.load(getClass().getResource("/MainGUI.fxml"));

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}