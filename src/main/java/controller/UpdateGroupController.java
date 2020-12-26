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

public class UpdateGroupController extends Application {
    @FXML
    public Button updButton = new Button();
    @FXML
    public Button exitButton = new Button();
    @FXML
    public Button getButton = new Button();
    @FXML
    public TextField nameText = new TextField();
    @FXML
    public TextField idText = new TextField();

    private MainService mainService = new MainService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/groupGUI/UpdateGroupGUI.fxml"));
        primaryStage.setTitle("修改组");
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ico.png")));
        primaryStage.show();
    }
@FXML
    public void updGroup() {
        if(nameText.getText()!=null){
            Group group = new Group();
            group.setG_name(nameText.getText());
            group.setG_id(Integer.parseInt(idText.getText()));
            int i = mainService.updateGroupByID(group);
            if(i!=0){
                Message.showMeg("提示", "修改成功");
                onExit();
                return;
            }
        }
        Message.showMeg("提示", "修改失败");
        onExit();
    }
@FXML
    public void onExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
@FXML
    public void getGroup() {
        if(nameText.getText()!=null){
            Group group = mainService.getGroupByName(nameText.getText());
            if(group!=null){
                idText.setText(String.valueOf(group.getG_id()));
            }
        }
    }
}
