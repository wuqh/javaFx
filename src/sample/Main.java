package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * 应用主要模块管理
 */
public class Main extends Application {

    private Stage mainStage;

  


    /**
     * 启动页
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        mainStage.setResizable(false);
     
        //设置窗口的图标.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));//界面模板
        Parent root = loader.load();
        primaryStage.setTitle("Welcome");
        Controller controller = loader.getController();
        controller.setApp(this);
        Scene scene = new Scene(root, 422, 297);
       // scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());//界面样式,类似css
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoMainUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
            Parent root = loader.load();
            mainStage.setTitle("Welcome");
            Controller controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 422, 297);
           // scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }



    /**
     * Add Student UI入口
     */
    public void gotoAddStudentUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));//界面模板
            Parent root = loader.load();
            mainStage.setTitle("Add Student");
            AddStudentController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 443.0, 530.0);
//            scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());//界面样式,类似css
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    
    
    /**
     * Process UI入口
     */
    public void gotoProcessUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Process.fxml"));//界面模板
            Parent root = loader.load();
            mainStage.setTitle("Add Student");
            ProcessController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 408, 255);
//            scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());//界面样式,类似css
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    
    /**
     * Result UI入口
     */
    public void gotoResultUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Result.fxml"));//界面模板
            Parent root = loader.load();
            mainStage.setTitle("Add Student");
            ResultController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 600.0, 678.0);
//            scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());//界面样式,类似css
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
