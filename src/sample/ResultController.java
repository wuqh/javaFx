package sample;

import java.net.URL;

import java.util.ResourceBundle;

import db.StoreUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	
	@FXML
	private Button btnExport;
	
	private Main myApp;
	
	
	public void setApp(Main myApp) {
        this.myApp = myApp;
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TableResult s1;
		int groupCount = 0;
		if(StoreUtils.students.size() / 4 < 1) {
			groupCount = 1;
		}else {
			if(StoreUtils.students.size() == 6) {
				groupCount = 6;
			}else if(StoreUtils.students.size() % 4 == 3) {
				groupCount = StoreUtils.students.size() / 4 + 1;
			}else {
				groupCount = StoreUtils.students.size() / 4;
			}
		}
		
		for(int i = 0; i < groupCount; i++) {
			s1 = new TableResult();
			s1.setCol1((i + 1) + "");
			s1.setCol2(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][0]).getName());
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][1] != null) {
				s1.setCol3(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][1]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][2] != null) {
				s1.setCol4(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][2]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][3] != null) {
				s1.setCol5(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][3]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][4] != null) {
				s1.setCol6(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][4]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][5] != null) {
				s1.setCol7(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][5].toString());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][6] != null) {
				s1.setCol8(StoreUtils.plans.get(StoreUtils.keyMinPlan1)[i][6].toString());
			}
			
			table1.getItems().add(s1);

		}
		
		for(int i = 0; i < groupCount; i++) {
			s1 = new TableResult();
			s1.setCol1((i + 1) + "");
			s1.setCol2(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][0]).getName());
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][1] != null) {
				s1.setCol3(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][1]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][2] != null) {
				s1.setCol4(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][2]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][3] != null) {
				s1.setCol5(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][3]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][4] != null) {
				s1.setCol6(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][4]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][5] != null) {
				s1.setCol7(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][5].toString());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][6] != null) {
				s1.setCol8(StoreUtils.plans.get(StoreUtils.keyMinPlan2)[i][6].toString());
			}
			
			table2.getItems().add(s1);
		}
		
		for(int i = 0; i < groupCount; i++) {
			s1 = new TableResult();
			s1.setCol1((i + 1) + "");
			s1.setCol2(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][0]).getName());
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][1] != null) {
				s1.setCol3(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][1]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][2] != null) {
				s1.setCol4(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][2]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][3] != null) {
				s1.setCol5(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][3]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][4] != null) {
				s1.setCol6(StoreUtils.students.get(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][4]).getName());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][5] != null) {
				s1.setCol7(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][5].toString());
			}
			if(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][6] != null) {
				s1.setCol8(StoreUtils.plans.get(StoreUtils.keyMinPlan3)[i][6].toString());
			}
			
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
