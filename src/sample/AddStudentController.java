package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import db.StoreUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rockywoo on 2019/2/15.
 */
public class AddStudentController  implements Initializable{

    private Main myApp;

    @FXML
    public ToggleGroup identity;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private JFXButton btn_ok;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private TextField sudent_name;

    @FXML
    private TextField first_subject_gpa_value;

    @FXML
    private Slider first_subject_gpa;


    public void setApp(Main myApp) {
        this.myApp = myApp;
    }



    @FXML
    public void OnOk(){
        Student student=new Student();
        if(identity.getSelectedToggle()==female){
            System.out.println("female");
            student.setGender("female");
        }else{
            System.out.println("male");
            student.setGender("male");
        }

        System.out.println(sudent_name.getText());
        student.setName(sudent_name.getText());
        StoreUtils.studentList.add(student);
        myApp.gotoMainUI();

    }

    @FXML
    public void OnCancel(){
        myApp.gotoMainUI();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        first_subject_gpa.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                first_subject_gpa_value.setText(first_subject_gpa.getValue()+"");
            }
        });



    }


}
