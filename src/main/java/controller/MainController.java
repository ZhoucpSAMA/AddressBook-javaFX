package controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import pojo.Group;
import pojo.Person;
import service.MainService;
import utils.Message;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private MainService mainService = new MainService();
    @FXML
    private TreeView<String> tree = null;

    @FXML
    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void refresh(ActionEvent event) {
        init();
    }

    @FXML
    public void addPerson(ActionEvent event) {
        try {
            new AddPersonController().start(new Stage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void GetPerson(ActionEvent event) {
        try {
            new GetPersonController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void UpdatePerson(ActionEvent event) {
        try {
            new UpdatePersonController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DelPerson(ActionEvent event) {
        try {
            new DelPersonController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddGroup(ActionEvent event) {
        try {
            new AddGroupController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DelGroup(ActionEvent event) {
        try {
            new DelGroupController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdGroup(ActionEvent event) {
        try {
            new UpdateGroupController().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @FXML
    private synchronized void init() {
//        tree.setCellFactory(p -> new TextFieldTreeCell<>(new DefaultStringConverter()));

        TreeItem<String> root = new TreeItem<>();
        root.setValue("通讯录");
        root.setExpanded(true);
        tree.setRoot(root);


        for (Group group : mainService.getAllGroup()) {
            TreeItem<String> item = createGroup(group.getG_name());
            for (Person person : mainService.getAllPerson()) {
                if (Objects.equals(person.getP_g_id(), group.getG_id())) {
                    createPerson(item, person.getP_name() + "    " + person.getP_phone());
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

    @FXML
    public void showHelp() {
        Message.showMeg("提示", "This project powered by 老周");
    }

    @FXML
    public void excel() {
        List<Person> allPerson = mainService.getAllPerson();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();

        ExcelWriter writer = ExcelUtil.getWriter(com.getPath() + "\\AddressBook.xlsx");
        writer.addHeaderAlias("p_name", "姓名");
        writer.addHeaderAlias("p_phone", "手机号");
        writer.addHeaderAlias("p_address", "地址");
        writer.addHeaderAlias("p_sex", "性别");
        writer.addHeaderAlias("p_g_id", "组号");
        writer.merge(4, "通讯录");
        writer.write(allPerson, true);
        writer.close();

        Message.showMeg("提示","导出成功到桌面查看！请勿重复导出！");

    }
}
