package sample;

import com.jfoenix.controls.JFXButton;
import db.StoreUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Main myApp;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_start;

    @FXML
    private Label numbers;

    public void setApp(Main myApp) {
        this.myApp = myApp;
    }


    @FXML
    public void onStart() {

    }


    @FXML
    public void onAdd() {
        myApp.gotoAddStudentUI();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numbers.setText(StoreUtils.studentList.size()+"");
    }
}
