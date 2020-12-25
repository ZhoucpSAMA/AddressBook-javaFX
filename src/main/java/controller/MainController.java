package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.converter.DefaultStringConverter;
import pojo.Group;
import pojo.Person;
import service.MainService;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private MainService mainService = new MainService();
    @FXML
    public TreeView<String> tree = null;

    @FXML
    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void refresh(ActionEvent event) {
        init();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @FXML
    private synchronized void init() {
        tree.setCellFactory(p -> new TextFieldTreeCell<>(new DefaultStringConverter()));

        TreeItem<String> root = new TreeItem<>();
        root.setValue("通讯录");
        root.setExpanded(true);

        tree.setRoot(root);
        for (Group group : mainService.getAllGroup()) {
            TreeItem<String> item = createGroup(group.getG_name());
            for (Person person : mainService.getAllPerson()) {
                if (Objects.equals(person.getP_g_id(), group.getG_id())) {
                    createPerson(item, person.getP_name() + "  " + person.getP_phone());
                }
            }
        }
    }

    @FXML
    public TreeItem<String> createGroup(String msg) {
        TreeItem<String> newItem = new TreeItem<>();
        newItem.setValue(msg);
        newItem.setExpanded(true);
        tree.getRoot().getChildren().add(newItem);
        tree.requestFocus();
        return newItem;
    }

    @FXML
    public void createPerson(TreeItem<String> group, String name) {
        TreeItem<String> newItem = new TreeItem<>();
        newItem.setValue(name);
        newItem.setExpanded(true);
        group.getChildren().add(newItem);
    }


}
