import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        Parent parent =  FXMLLoader.load(getClass().getResource("/MainGUI.fxml"));
        primaryStage.setTitle("通讯录 - Powered by 老周");
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ico.png")));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}