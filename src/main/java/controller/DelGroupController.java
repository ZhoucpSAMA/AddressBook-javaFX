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

public class DelGroupController extends Application {
    @FXML
    public Button delButton = new Button();
    @FXML
    public Button exitButton = new Button();
    @FXML
    public TextField nameText = new TextField();

    private MainService mainService = new MainService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/groupGUI/DelGroupGUI.fxml"));
        primaryStage.setTitle("删除组");
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ico.png")));
        primaryStage.show();
    }
    @FXML
    public void delGroup() {
        String groupName = nameText.getText();
        Group group = mainService.getGroupByName(groupName);
        if ( group != null) {
            int i = mainService.delGroupByName(groupName);
            int j = mainService.delPersonByGroupID(group.getG_id());
            if (i!=0&&j!=0) {
                Message.showMeg("提示", "删除成功");
                onExit();
                return;
            }
        }
        Message.showMeg("提示", "删除失败");
        onExit();
    }
    @FXML
    public void onExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
