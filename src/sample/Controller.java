package sample;

import com.jfoenix.controls.JFXButton;
import db.StoreUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Student;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Main myApp;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnStart;

    @FXML
    private Label studentNum;

    public void setApp(Main myApp) {
        this.myApp = myApp;
    }


    @FXML
    public void onStart() {
//    	myApp.gotoResultUI();
    	
    	myApp.gotoProcessUI();
    	
//    	//Initialise variables
//    	Map<Integer, Student> studentsTemp = new HashMap<Integer, Student>();
//    	int studentNum = StoreUtils.students.size();
//    	int groupNum = studentNum / 4;
//    	int remainder = studentNum % 4;
//    	int planNum = 0;
//    	//int allPlanNum = ;
//    	//Map<Integer, PlanAndRes> plans = new HashMap<Integer, PlanAndRes>();
//    	Map<Integer, Integer[][]> plans = new HashMap<Integer, Integer[][]>();
//    	Map<Integer, Student> remainedStudents = new HashMap<Integer, Student>();
//    	Map<Integer, Student> unmatchedStudents = new HashMap<Integer, Student>();
//    	Integer[][] plan = new Integer[groupNum + 1][7];
//    	double sd1 = 0;
//    	double sd2 = 0;
//    	double sd3 = 0;
//    	double minSD1 = 0;
//    	double minSD2 = 0;
//    	double minSD3 = 0;
//    	Integer keyMinPlan1 = new Integer(-1);
//    	Integer keyMinPlan2 = new Integer(-1);
//    	Integer keyMinPlan3 = new Integer(-1);
//    	Random random = new Random();
//    	boolean stop = false;
//    	
//    	//Loop for generating grouping plans
//    	while(true) {
//    		
//    		//Copy all elements from Map "students" to a temporary Map
//    		for(int i = 0; i < studentNum; i++) {
//        		studentsTemp.put(new Integer(i), StoreUtils.students.get(new Integer(i)));
//        	}
//    		
//    		//Initialise the number of students assigned to each subject
//    		int[] subjectNums = {0, 0, 0, 0};
//    		
//    		/*Randomly copy extra students to a temporary Map and remove from
//    		"studentsTemp", so number of students is currently a multiple of 4*/
//    		for(int i = 0; i < remainder; i++) {
//    			Integer keyRemain = new Integer(random.nextInt(studentNum));
//    			remainedStudents.put(keyRemain, studentsTemp.get(keyRemain));
//    			studentsTemp.remove(keyRemain);
//    		}
//    		
//    		int sortCount = studentsTemp.size();
//    		
//    		//Loop for sorting currently remaining students into a grouping plan
//    		for(int i = 0; i < sortCount; i++) {
//    			
//    			//Randomly find the key of a remaining unsorted student
//    			Integer[] keys = studentsTemp.keySet().toArray(new Integer[0]);
//    			Integer keySort = keys[random.nextInt(keys.length)];
//    			
//    			//Represent the subjects that this student takes 
//    			int sub1 = -1;
//    			int sub2 = -1;
//    			if(studentsTemp.get(keySort).getSubject1().equals("Physics")) {
//    				sub1 = 0;
//    			}else if(studentsTemp.get(keySort).getSubject1().equals("Chemistry")) {
//    				sub1 = 1;
//    			}else if(studentsTemp.get(keySort).getSubject1().equals("Biology")) {
//    				sub1 = 2;
//    			}else if(studentsTemp.get(keySort).getSubject1().equals("CS")) {
//    				sub1 = 3;
//    			}
//    			
//    			if(studentsTemp.get(keySort).getSubject2().equals("Physics")) {
//    				sub2 = 0;
//    			}else if(studentsTemp.get(keySort).getSubject2().equals("Chemistry")) {
//    				sub2 = 1;
//    			}else if(studentsTemp.get(keySort).getSubject2().equals("Biology")) {
//    				sub2 = 2;
//    			}else if(studentsTemp.get(keySort).getSubject2().equals("CS")) {
//    				sub2 = 3;
//    			}else if(studentsTemp.get(keySort).getSubject2().equals("None")) {
//    				sub2 = 4;
//    			}
//    			
//    			//Sort this student to one subject
//    			if(sub2 == 4) {//If the student takes only one subject
//    				if(subjectNums[sub1] < groupNum) {
//    					plan[subjectNums[sub1]][sub1] = keySort;
//    					subjectNums[sub1] = subjectNums[sub1] + 1;
//    					studentsTemp.remove(keySort);
//    				}else {//If the chosen subject is already full
//    					unmatchedStudents.put(keySort, studentsTemp.get(keySort));
//    					studentsTemp.remove(keySort);
//    				}
//    			}else {//If the student takes two subjects
//    				int subjectIndex = random.nextInt(2);//Randomly choose between two subjects
//    				if(subjectIndex == 0) {//Assign student to Subject 1
//    					if(subjectNums[sub1] < groupNum) {
//    						plan[subjectNums[sub1]][sub1] = keySort;
//        					subjectNums[sub1] = subjectNums[sub1] + 1;
//        					studentsTemp.remove(keySort);
//        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA1());
//    					}else if(subjectNums[sub2] < groupNum) {//If Subject 1 is full, choose Subject 2
//    						plan[subjectNums[sub2]][sub2] = keySort;
//        					subjectNums[sub2] = subjectNums[sub2] + 1;
//        					studentsTemp.remove(keySort);
//        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA2());
//    					}else {//If both subjects are full, temporarily store student in another Map
//    						unmatchedStudents.put(keySort, studentsTemp.get(keySort));
//        					studentsTemp.remove(keySort);
//    					}
//    				}else if(subjectIndex == 1) {//Assign student to Subject 2
//    					if(subjectNums[sub2] < groupNum) {
//    						plan[subjectNums[sub2]][sub2] = keySort;
//        					subjectNums[sub2] = subjectNums[sub2] + 1;
//        					studentsTemp.remove(keySort);
//        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA2());
//    					}else if(subjectNums[sub1] < groupNum) {//If Subject 2 is full, choose Subject 1
//    						plan[subjectNums[sub1]][sub1] = keySort;
//        					subjectNums[sub1] = subjectNums[sub1] + 1;
//        					studentsTemp.remove(keySort);
//        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA1());
//    					}else {//If both subjects are full, temporarily store unmatched student in another Map
//    						unmatchedStudents.put(keySort, studentsTemp.get(keySort));
//        					studentsTemp.remove(keySort);
//    					}
//    				}
//    			}
//    		}
//    		
//    		int unmatchCount = unmatchedStudents.size();
//    		
//    		//Fit unmatched students into the grouping plan
//    		for(int i = 0; i < unmatchCount; i++) {
//    			
//    			//Randomly find the key of an unmatched student
//    			Integer[] keys = unmatchedStudents.keySet().toArray(new Integer[0]);
//    			Integer keyUnmatch = keys[random.nextInt(keys.length)];
//    			
//    			//Assign this student to a subject that is not full
//    			if(subjectNums[0] < groupNum) {//If Physics is not full, assign student to Physics
//    				plan[subjectNums[0]][0] = keyUnmatch;
//    				subjectNums[0] = subjectNums[0] + 1;
//    				unmatchedStudents.remove(keyUnmatch);
//    			}else if(subjectNums[1] < groupNum) {//If Chemistry is not full, assign student to Chemistry
//    				plan[subjectNums[1]][1] = keyUnmatch;
//    				subjectNums[1] = subjectNums[1] + 1;
//    				unmatchedStudents.remove(keyUnmatch);
//    			}else if(subjectNums[2] < groupNum) {//If Biology is not full, assign student to Biology
//    				plan[subjectNums[2]][2] = keyUnmatch;
//    				subjectNums[2] = subjectNums[2] + 1;
//    				unmatchedStudents.remove(keyUnmatch);
//    			}else if(subjectNums[3] < groupNum) {//If CS is not full, assign student to CS
//    				plan[subjectNums[3]][3] = keyUnmatch;
//    				subjectNums[3] = subjectNums[3] + 1;
//    				unmatchedStudents.remove(keyUnmatch);
//    			}
//    			
//    			//Use the higher GPA of the student for evaluation if the student takes two subjects
//    			if(StoreUtils.students.get(keyUnmatch).getGPA1() > StoreUtils.students.get(keyUnmatch).getGPA2()) {
//    				StoreUtils.students.get(keyUnmatch).setFinalGPA(StoreUtils.students.get(keyUnmatch).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyUnmatch).setFinalGPA(StoreUtils.students.get(keyUnmatch).getGPA2());
//    			}
//    		}
//    		
//    		//If there was one extra student taken out at the beginning
//    		if(remainedStudents.size() == 1) {
//    			
//    			//Find the key of the extra student
//    			Integer[] key = remainedStudents.keySet().toArray(new Integer[0]);
//    			Integer keyRemain = key[0];
//    			
//    			//Add the student to a group
//    			plan[groupNum - 1][4] = keyRemain;
//    			remainedStudents.remove(keyRemain);
//    			
//    			//Use the higher GPA of the student for evaluation if the student takes two subjects
//    			if(StoreUtils.students.get(keyRemain).getGPA1() > StoreUtils.students.get(keyRemain).getGPA2()) {
//    				StoreUtils.students.get(keyRemain).setFinalGPA(StoreUtils.students.get(keyRemain).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain).setFinalGPA(StoreUtils.students.get(keyRemain).getGPA2());
//    			}
//    		}
//    		
//    		//If there were two extra students taken out at the beginning
//    		if(remainedStudents.size() == 2) {
//    			
//    			//Find the keys of the extra students
//    			Integer[] keys = remainedStudents.keySet().toArray(new Integer[0]);
//    			Integer keyRemain1 = keys[0];
//    			Integer keyRemain2 = keys[1];
//    			
//    			//Add each student to a group
//    			plan[groupNum - 2][4] = keyRemain1;
//    			plan[groupNum - 1][4] = keyRemain2;
//    			
//    			//Use the higher GPAs of the students for evaluation if they take two subjects
//    			if(StoreUtils.students.get(keyRemain1).getGPA1() > StoreUtils.students.get(keyRemain1).getGPA2()) {
//    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA2());
//    			}
//    			
//    			if(StoreUtils.students.get(keyRemain2).getGPA1() > StoreUtils.students.get(keyRemain2).getGPA2()) {
//    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA2());
//    			}
//    		}
//    		
//    		//If there were three extra students taken out at the beginning
//    		if(remainedStudents.size() == 3) {
//    			
//    			//Find the keys of the extra students
//    			Integer[] keys = remainedStudents.keySet().toArray(new Integer[0]);
//    			Integer keyRemain1 = keys[0];
//    			Integer keyRemain2 = keys[1];
//    			Integer keyRemain3 = keys[2];
//    			
//    			//Create one new group of 3
//    			plan[groupNum][0] = keyRemain1;
//    			plan[groupNum][1] = keyRemain2;
//    			plan[groupNum][2] = keyRemain3;
//    			groupNum = groupNum + 1;
//    			
//    			//Use the higher GPA of each student for evaluation if they take two subjects
//    			if(StoreUtils.students.get(keyRemain1).getGPA1() > StoreUtils.students.get(keyRemain1).getGPA2()) {
//    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA2());
//    			}
//    			
//    			if(StoreUtils.students.get(keyRemain2).getGPA1() > StoreUtils.students.get(keyRemain2).getGPA2()) {
//    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA2());
//    			}
//    			
//    			if(StoreUtils.students.get(keyRemain3).getGPA1() > StoreUtils.students.get(keyRemain3).getGPA2()) {
//    				StoreUtils.students.get(keyRemain3).setFinalGPA(StoreUtils.students.get(keyRemain3).getGPA1());
//    			}else{
//    				StoreUtils.students.get(keyRemain3).setFinalGPA(StoreUtils.students.get(keyRemain3).getGPA2());
//    			}
//    		}
//    		
//    		int groupGPAAverage = 0;
//    		
//    		//Calculate and display the average GPA of each group
//    		for(int i = 0; i < groupNum; i++) {
//    			int groupGPASum = 0;
//    			for(int j = 0; j < 5; j++) {
//    				groupGPASum = groupGPASum + StoreUtils.students.get(plan[i][j]).getFinalGPA();
//    			}
//    			if(plan[i][4] == null) {
//    				if(plan[i][3] != null) {
//    					groupGPAAverage = groupGPASum / 4;
//    				}else {
//    					groupGPAAverage = groupGPASum / 3;
//    				}
//    			}else {
//    				groupGPAAverage = groupGPASum / 5;
//    			}
//    			plan[i][5] = new Integer(groupGPAAverage);
//    		}
//    		
//    		int groupPersAverage = 0;
//    		
//    		//Calculate and display the average Personality Index of each group
//    		for(int i = 0; i < groupNum; i++) {
//    			int groupPersSum = 0;
//    			for(int j = 0; j < 5; j++) {
//    				groupPersSum = groupPersSum + StoreUtils.students.get(plan[i][j]).getFinalPersonality();
//    			}
//    			if(plan[i][4] == null) {
//    				if(plan[i][3] != null) {
//    					groupPersAverage = groupPersSum / 4;
//    				}else {
//    					groupPersAverage = groupPersSum / 3;
//    				}
//    			}else {
//    				groupPersAverage = groupPersSum / 5;
//    			}
//    			plan[i][6] = new Integer(groupPersAverage);
//    		}
//    		
//    		//Calculate standard deviation of the groups' GPAs
//    		double totalGPASD = 0;
//    		int totalGPASum = 0;
//    		double totalGPAAverage = 0;
//    		double totalGPADeviation = 0;
//    		int gpaTemp = 0;
//    		for(int i = 0; i < groupNum; i++) {
//    			gpaTemp = plan[i][5];
//                totalGPASum = totalGPASum + gpaTemp;
//            }
//    		totalGPAAverage = totalGPASum / groupNum;
//    		for(int i = 0; i < groupNum; i++) {
//    			gpaTemp = plan[i][5];
//                totalGPADeviation = totalGPADeviation + Math.pow((gpaTemp - totalGPAAverage), 2);
//            }
//    		totalGPASD = Math.sqrt(totalGPADeviation / groupNum);
//    		
//    		//Calculate standard deviation of the groups' GPAs
//    		double totalPersSD = 0;
//    		int totalPersSum = 0;
//    		double totalPersAverage = 0;
//    		double totalPersDeviation = 0;
//    		int persTemp = 0;
//    		for(int i = 0; i < groupNum; i++) {
//    			persTemp = plan[i][5];
//                totalPersSum = totalPersSum + persTemp;
//            }
//    		totalPersAverage = totalPersSum / groupNum;
//    		for(int i = 0; i < groupNum; i++) {
//    			persTemp = plan[i][5];
//                totalPersDeviation = totalPersDeviation + Math.pow((persTemp - totalPersAverage), 2);
//            }
//    		totalPersSD = Math.sqrt(totalPersDeviation / groupNum);
//    		
//    		//Calculate 3 overall standard deviations according to 3 weightings
//    		sd1 = (totalGPASD * 0.6) + (totalPersSD * 0.4);
//    		sd2 = (totalGPASD * 0.85) + (totalPersSD * 0.15);
//    		sd3 = (totalGPASD * 0.35) + (totalPersSD * 0.65);
//    		
//    		//Check if this generated plan is the first plan
//    		if(keyMinPlan1.intValue() == -1 || keyMinPlan2.intValue() == -1 || keyMinPlan3.intValue() == -1) {
//    			keyMinPlan1 = 0;
//    			keyMinPlan2 = 0;
//    			keyMinPlan3 = 0;
//    			plans.put(keyMinPlan1, plan);
//    			minSD1 = sd1;
//    			minSD2 = sd2;
//    			minSD3 = sd3;
//    		}else {//If not, check if this plan has a smallest standard deviation in all plans. If yes, replace the previous best plan
//    			if(sd1 < minSD1) {
//    				keyMinPlan1 = plans.size();
//    				minSD1 = sd1;
//    			}
//    			if(sd2 < minSD2) {
//    				keyMinPlan2 = plans.size();
//    				minSD2 = sd2;
//    			}
//    			if(sd3 < minSD3) {
//    				keyMinPlan3 = plans.size();
//    				minSD3 = sd3;
//    			}
//    			
//    			//Check if the generated plan already exists. If not, add to collection
//    			if(!plans.containsValue(plan)) {
//    				plans.put(new Integer(plans.size()), plan);
//    				planNum = planNum + 1;
//    			}
//    		}
//    		
//    		if(stop) {
//    			break;
//    		}
//    	}
    }


    @FXML
    public void onAdd() {
        myApp.gotoAddStudentUI();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentNum.setText(StoreUtils.students.size() + "");
    }
}
