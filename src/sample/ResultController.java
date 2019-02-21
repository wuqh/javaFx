package sample;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import model.TableResult;

public class ResultController implements Initializable {
	@FXML
	private TableView<Student> table1;
	@FXML
	TableColumn<Student,String> t1col1;
	@FXML
	TableColumn<Student,String> t1col2;
	@FXML
	TableColumn<Student,String> t1col3;
	@FXML
	TableColumn<Student,String> t1col4;
	@FXML
	TableColumn<Student,String> t1col5;
	@FXML
	TableColumn<Student,String> t1col6;
	@FXML
	TableColumn<Student,String> t1col7;
	
	@FXML
	private TableView<Student> table2;
	@FXML
	TableColumn<Student,String> t2col1;
	@FXML
	TableColumn<Student,String> t2col2;
	@FXML
	TableColumn<Student,String> t2col3;
	@FXML
	TableColumn<Student,String> t2col4;
	@FXML
	TableColumn<Student,String> t2col5;
	@FXML
	TableColumn<Student,String> t2col6;
	@FXML
	TableColumn<Student,String> t2col7;
	
	@FXML
	private TableView<Student> table3;
	
	@FXML
	TableColumn<Student,String> t3col1;
	@FXML
	TableColumn<Student,String> t3col2;
	@FXML
	TableColumn<Student,String> t3col3;
	@FXML
	TableColumn<Student,String> t3col4;
	@FXML
	TableColumn<Student,String> t3col5;
	@FXML
	TableColumn<Student,String> t3col6;
	@FXML
	TableColumn<Student,String> t3col7;
	
	private Main myApp;
	
	
	public void setApp(Main myApp) {
        this.myApp = myApp;
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TableResult s1;
		for(int i=0;i<100;i++) {
			s1 = new TableResult();
			s1.setCol1(i+"");
			s1.setCol2("name");
			s1.setCol3("col3");
			table1.getItems().add(s1);

		}
		
		for(int i=0;i<100;i++) {
			s1 = new TableResult();
			s1.setCol1(i+"");
			s1.setCol2("name");
			s1.setCol3("col3");		
			table2.getItems().add(s1);
		}
		
		for(int i=0;i<100;i++) {
			s1 = new TableResult();
			s1.setCol1(i+"");
			s1.setCol2("name");
			s1.setCol3("col3");
			table3.getItems().add(s1);
		}
		
		
	
		
		
///////////////////////////////////////////////////////////
		

		//display table1 student's attribute
		t1col1.setCellValueFactory(new PropertyValueFactory<Student,String>("col1"));
		t1col2.setCellValueFactory(new PropertyValueFactory<Student,String>("col2"));
		t1col3.setCellValueFactory(new PropertyValueFactory<Student,String>("col3"));
		t1col4.setCellValueFactory(new PropertyValueFactory<Student,String>("col4"));
		t1col5.setCellValueFactory(new PropertyValueFactory<Student,String>("col5"));
		t1col6.setCellValueFactory(new PropertyValueFactory<Student,String>("col6"));
		t1col7.setCellValueFactory(new PropertyValueFactory<Student,String>("col7"));
		
		//display table2 student's attribute
		t2col1.setCellValueFactory(new PropertyValueFactory<Student,String>("col1"));
		t2col2.setCellValueFactory(new PropertyValueFactory<Student,String>("col2"));
		t2col2.setCellValueFactory(new PropertyValueFactory<Student,String>("col2"));
		t2col3.setCellValueFactory(new PropertyValueFactory<Student,String>("col3"));
		t2col4.setCellValueFactory(new PropertyValueFactory<Student,String>("col4"));
		t2col5.setCellValueFactory(new PropertyValueFactory<Student,String>("col5"));
		t2col6.setCellValueFactory(new PropertyValueFactory<Student,String>("col6"));
		t2col7.setCellValueFactory(new PropertyValueFactory<Student,String>("col7"));
		
		//display table3 student's attribute
		t3col1.setCellValueFactory(new PropertyValueFactory<Student,String>("col1"));
		t3col2.setCellValueFactory(new PropertyValueFactory<Student,String>("col2"));
		t3col2.setCellValueFactory(new PropertyValueFactory<Student,String>("col2"));
		t3col3.setCellValueFactory(new PropertyValueFactory<Student,String>("col3"));
		t3col4.setCellValueFactory(new PropertyValueFactory<Student,String>("col4"));
		t3col5.setCellValueFactory(new PropertyValueFactory<Student,String>("col5"));
		t3col6.setCellValueFactory(new PropertyValueFactory<Student,String>("col6"));
		t3col7.setCellValueFactory(new PropertyValueFactory<Student,String>("col7"));
		
		
	
		
	
		
		

	}

}
