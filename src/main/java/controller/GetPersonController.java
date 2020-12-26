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
import pojo.Person;
import service.MainService;
import utils.Message;

public class GetPersonController extends Application {
    @FXML
    public TextField nameText = new TextField();
    @FXML
    public TextField phoneText = new TextField();
    @FXML
    public TextField addressText = new TextField();
    @FXML
    public TextField groupText = new TextField();
    @FXML
    public TextField sexText = new TextField();
    @FXML
    private Button getButton = new Button();
    @FXML
    private Button exitButton = new Button();

    private MainService mainService = new MainService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/personGUI/GetPersonGUI.fxml"));
        primaryStage.setTitle("查询");
        primaryStage.setScene(new Scene(parent));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ico.png")));
        primaryStage.show();
    }

    @FXML
    public void getPerson() {
        if(nameText!=null){
            Person person = mainService.getPersonByName(nameText.getText());
            if(person!=null){
                phoneText.setText(person.getP_phone());
                addressText.setText(person.getP_address());
                String groupNameByID = mainService.getGroupNameByID(person.getP_g_id());
                groupText.setText(groupNameByID);
                sexText.setText(person.getP_sex());
                Message.showMeg("提示","查询成功");
                return;
            }
        }
        phoneText.setText(null);
        addressText.setText(null);
        groupText.setText(null);
        sexText.setText(null);
        Message.showMeg("提示","查询失败");

    }

    @FXML
    public void onExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }
}
