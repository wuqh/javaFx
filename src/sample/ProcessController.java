package sample;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import model.Student;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import db.StoreUtils;

/**
 * Created by rockywoo on 2019/2/15.
 */
public class ProcessController implements Initializable {

    private Main myApp;
    
    
    
  
    
    public void setApp(Main myApp) {
        this.myApp = myApp;
    }

    @FXML
    ProgressBar process;
    
    @FXML
    Label labelProcess;
    
    @FXML
    Label percentage;
    
    Thread thread;
    
//    boolean stop = false;


    @FXML
    public void onStop(){
    	StoreUtils.stop = true;
    	thread.interrupt();
//        myApp.gotoMainUI();
        myApp.gotoResultUI();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	CalThread calThread=new CalThread(process);
    	thread=new Thread(calThread);
 
    	thread.start();
    }
    
    
    
    
    
    
    
}
