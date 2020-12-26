package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pojo.Group;
import service.MainService;
import utils.Message;

public class AddGroupController extends Application {
    @FXML
    public Button addButton = new Button();
    @FXML
    public Button exitButton = new Button();
    @FXML
    public TextField nameText = new TextField();

    private MainService mainService = new MainService();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/groupGUI/AddGroupGUI.fxml"));
        primaryStage.setTitle("添加组");
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ico.png")));
        primaryStage.show();
    }

    @FXML
    public void addGroup() {
        Group group = new Group();
        group.setG_name(nameText.getText());
        if (nameText.getText() != null) {
            if (mainService.addGroup(group) != 0) {
                Message.showMeg("提示", "添加成功");
                onExit();
                return;

            }
        }
        Message.showMeg("提示", "添加失败");
        onExit();
    }

    @FXML
    public void onExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
