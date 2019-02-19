package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

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
    public void onStop(){
        myApp.gotoMainUI();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
