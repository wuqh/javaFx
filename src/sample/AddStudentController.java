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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton rbtnFemale;

    @FXML
    private RadioButton rbtnMale;
    
    @FXML
    private ToggleGroup sub1Group;
    
    @FXML
    private RadioButton rbtnSubP1;
    
    @FXML
    private RadioButton rbtnSubC1;
    
    @FXML
    private RadioButton rbtnSubB1;
    
    @FXML
    private RadioButton rbtnSubCS1;
    
    @FXML
    private ToggleGroup sub2Group;
    
    @FXML
    private RadioButton rbtnSubP2;
    
    @FXML
    private RadioButton rbtnSubC2;
    
    @FXML
    private RadioButton rbtnSubB2;
    
    @FXML
    private RadioButton rbtnSubCS2;
    
    @FXML
    private RadioButton rbtnNone;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField textName;

    @FXML
    private TextField textGPA1;
    
    @FXML
    private TextField textGPA2;
    
    @FXML
    private TextField textQ1;
    
    @FXML
    private TextField textQ2;
    
    @FXML
    private TextField textQ3;

    @FXML
    private Slider sliderGPA1;
    
    @FXML
    private Slider sliderGPA2;
    
    @FXML
    private Slider sliderQ1;
    
    @FXML
    private Slider sliderQ2;
    
    @FXML
    private Slider sliderQ3;


    public void setApp(Main myApp) {
        this.myApp = myApp;
    }



    @FXML
    public void OnOk(){
    	if(sub2Group.getSelectedToggle() == rbtnNone) {
    		if(textName.getText().equals("") || genderGroup.getSelectedToggle() == null || sub1Group.getSelectedToggle() == null || sliderGPA1.getValue() == 0 || sliderQ1.getValue() == 0 || sliderQ2.getValue() == 0 || sliderQ3.getValue() == 0) {
    			Alert error = new Alert(Alert.AlertType.ERROR, "You must complete all entries");
    			error.showAndWait();
    		}else {
    			Student student=new Student();
    	    	
//    	    	String name = textName.getText();
//    	    	String gender = null;
//    	    	String sub1 = null;
//    	    	String sub2 = null;
    	    	int gpa1 = 0;
    	    	int gpa2 = -1;
    	    	int finalPersonality = 0;
    	    	
    	    	student.setName(textName.getText());
    	        
    	        if(genderGroup.getSelectedToggle() == rbtnFemale){
//    	        	gender = "female";
//    	            System.out.println("female");
    	            student.setGender("female");
    	        }else if(genderGroup.getSelectedToggle() == rbtnMale){
//    	        	gender = "male";
//    	            System.out.println("male");
    	            student.setGender("male");
    	        }
    	        
    	        if(sub1Group.getSelectedToggle() == rbtnSubP1) {
    	        	student.setSubject1("physics");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubC1) {
    	        	student.setSubject1("chemistry");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubB1) {
    	        	student.setSubject1("biology");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubCS1) {
    	        	student.setSubject1("cs");
    	        }
    	        
    	        student.setSubject2("none");
    	        
    	        gpa1 = Double.valueOf(sliderGPA1.getValue()).intValue();
    	        student.setGPA1(gpa1);
    	        student.setGPA2(gpa2);
    	        
    	        finalPersonality = (Double.valueOf(sliderQ1.getValue()).intValue() + Double.valueOf(sliderQ2.getValue()).intValue() + Double.valueOf(sliderQ3.getValue()).intValue()) / 3 * 5;
    	        student.setFinalPersonality(finalPersonality);

//    	        System.out.println(sudent_name.getText());
//    	        student.setName(sudent_name.getText());
//    	        StoreUtils.studentList.add(student);
    	       
    	        StoreUtils.students.put(StoreUtils.index, student);
    	        StoreUtils.index = StoreUtils.index + 1;
    	        myApp.gotoMainUI();
    		}
    	}else {
    		if(textName.getText().equals("") || genderGroup.getSelectedToggle() == null || sub1Group.getSelectedToggle() == null || sub2Group.getSelectedToggle() == null || sliderGPA1.getValue() == 0 || sliderGPA2.getValue() == 0 || sliderQ1.getValue() == 0 || sliderQ2.getValue() == 0 || sliderQ3.getValue() == 0) {
    			Alert error = new Alert(Alert.AlertType.ERROR, "You must complete all entries");
    			error.showAndWait();
    		}else {
    			Student student=new Student();
    	    	
//    	    	String name = textName.getText();
//    	    	String gender = null;
//    	    	String sub1 = null;
//    	    	String sub2 = null;
    	    	int gpa1 = 0;
    	    	int gpa2 = 0;
    	    	int finalPersonality = 0;
    	    	
    	    	student.setName(textName.getText());
    	        
    	        if(genderGroup.getSelectedToggle() == rbtnFemale){
//    	        	gender = "female";
//    	            System.out.println("female");
    	            student.setGender("female");
    	        }else if(genderGroup.getSelectedToggle() == rbtnMale){
//    	        	gender = "male";
//    	            System.out.println("male");
    	            student.setGender("male");
    	        }
    	        
    	        if(sub1Group.getSelectedToggle() == rbtnSubP1) {
    	        	student.setSubject1("physics");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubC1) {
    	        	student.setSubject1("chemistry");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubB1) {
    	        	student.setSubject1("biology");
    	        }else if(sub1Group.getSelectedToggle() == rbtnSubCS1) {
    	        	student.setSubject1("cs");
    	        }
    	        
    	        if(sub2Group.getSelectedToggle() == rbtnSubP2) {
    	        	student.setSubject2("physics");
    	        }else if(sub2Group.getSelectedToggle() == rbtnSubC2) {
    	        	student.setSubject2("chemistry");
    	        }else if(sub2Group.getSelectedToggle() == rbtnSubB2) {
    	        	student.setSubject2("biology");
    	        }else if(sub2Group.getSelectedToggle() == rbtnSubCS2) {
    	        	student.setSubject2("cs");
    	        }
//    	        	else if(sub2Group.getSelectedToggle() == rbtnNone) {
//    	        	student.setSubject2("none");
//    	        }
    	        
    	        gpa1 = Double.valueOf(sliderGPA1.getValue()).intValue();
    	        student.setGPA1(gpa1);
    	        gpa2 = Double.valueOf(sliderGPA2.getValue()).intValue();
    	        student.setGPA2(gpa2);
    	        
    	        finalPersonality = (Double.valueOf(sliderQ1.getValue()).intValue() + Double.valueOf(sliderQ2.getValue()).intValue() + Double.valueOf(sliderQ3.getValue()).intValue()) / 3 * 5;
    	        student.setFinalPersonality(finalPersonality);

//    	        System.out.println(sudent_name.getText());
//    	        student.setName(sudent_name.getText());
//    	        StoreUtils.studentList.add(student);
    	       
    	        StoreUtils.students.put(StoreUtils.index, student);
    	        StoreUtils.index = StoreUtils.index + 1;
    	        myApp.gotoMainUI();
    		}
    	}
    }

    @FXML
    public void OnCancel(){
        myApp.gotoMainUI();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sliderGPA1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                textGPA1.setText(Double.valueOf(sliderGPA1.getValue()).intValue()+"");
            }
        });
        
        sliderGPA2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                textGPA2.setText(Double.valueOf(sliderGPA2.getValue()).intValue()+"");
            }
        });
        
        sliderQ1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                textQ1.setText(Double.valueOf(sliderQ1.getValue()).intValue()+"");
            }
        });
        
        sliderQ2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                textQ2.setText(Double.valueOf(sliderQ2.getValue()).intValue()+"");
            }
        });

        sliderQ3.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                textQ3.setText(Double.valueOf(sliderQ3.getValue()).intValue()+"");
            }
        });

    }


}
