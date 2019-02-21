package sample;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import db.StoreUtils;
import javafx.scene.control.ProgressBar;
import model.Student;

public class CalThread implements Runnable{
	
	boolean stop = false;
	
	ProgressBar process;
	
	private Date start;
    
    private int minute=5;//run time
	
	public CalThread(ProgressBar process) {
		start=new Date();
		this.process=process;
	}
	
	private void updateProcessBar() {
    	int maxProcess=minute*60;
    	Calendar current=Calendar.getInstance();
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(start);
    	cal.add(Calendar.MINUTE, minute);
    	//curent time more than start time
    	if(current.getTimeInMillis()>cal.getTimeInMillis()){
    		stop = true;
    	}else {
    		double currentProcess=(current.getTimeInMillis()-cal.getTimeInMillis())/1000;
    		currentProcess=currentProcess/maxProcess;
    		process.setProgress(currentProcess);
    	}
    	
    }
	
	

	@Override
	public void run() {
		//Initialise variables
    	Map<Integer, Student> studentsTemp = new HashMap<Integer, Student>();
    	int studentNum = StoreUtils.students.size();
    	int groupNum = studentNum / 4;
    	int remainder = studentNum % 4;
    	int planNum = 0;
    	//int allPlanNum = ;
    	//Map<Integer, PlanAndRes> plans = new HashMap<Integer, PlanAndRes>();
    	
    	Map<Integer, Student> remainedStudents = new HashMap<Integer, Student>();
    	Map<Integer, Student> unmatchedStudents = new HashMap<Integer, Student>();
    	Integer[][] plan = new Integer[groupNum + 1][7];
    	double sd1 = 0;
    	double sd2 = 0;
    	double sd3 = 0;
    	double minSD1 = 0;
    	double minSD2 = 0;
    	double minSD3 = 0;
    	
    	Random random = new Random();
    	boolean stop;
    	
    	
    	//Loop for generating grouping plans
    	while(true) {
//    		updateProcessBar();
    		
    		stop = StoreUtils.stop;
    		
    		//Copy all elements from Map "students" to a temporary Map
    		for(int i = 0; i < studentNum; i++) {
        		studentsTemp.put(new Integer(i), StoreUtils.students.get(new Integer(i)));
        	}
    		
    		//Initialise the number of students assigned to each subject
    		int[] subjectNums = {0, 0, 0, 0};
    		
    		/*Randomly copy extra students to a temporary Map and remove from
    		"studentsTemp", so number of students is currently a multiple of 4*/
    		for(int i = 0; i < remainder; i++) {
    			Integer keyRemain = new Integer(random.nextInt(studentNum));
    			remainedStudents.put(keyRemain, studentsTemp.get(keyRemain));
    			studentsTemp.remove(keyRemain);
    		}
    		
    		int sortCount = studentsTemp.size();
    		
    		//Loop for sorting currently remaining students into a grouping plan
    		for(int i = 0; i < sortCount; i++) {
    			
    			//Randomly find the key of a remaining unsorted student
    			Integer[] keys = studentsTemp.keySet().toArray(new Integer[0]);
    			Integer keySort = keys[random.nextInt(keys.length)];
    			
    			
    			//Represent the subjects that this student takes 
    			int sub1 = -1;
    			int sub2 = -1;
    			if(studentsTemp.get(keySort).getSubject1().equals("physics")) {
    				sub1 = 0;
    			}else if(studentsTemp.get(keySort).getSubject1().equals("chemistry")) {
    				sub1 = 1;
    			}else if(studentsTemp.get(keySort).getSubject1().equals("biology")) {
    				sub1 = 2;
    			}else if(studentsTemp.get(keySort).getSubject1().equals("cs")) {
    				sub1 = 3;
    			}
    			
    			if(studentsTemp.get(keySort).getSubject2().equals("physics")) {
    				sub2 = 0;
    			}else if(studentsTemp.get(keySort).getSubject2().equals("chemistry")) {
    				sub2 = 1;
    			}else if(studentsTemp.get(keySort).getSubject2().equals("biology")) {
    				sub2 = 2;
    			}else if(studentsTemp.get(keySort).getSubject2().equals("cs")) {
    				sub2 = 3;
    			}else if(studentsTemp.get(keySort).getSubject2().equals("none")) {
    				sub2 = 4;
    			}
    			
    			//Sort this student to one subject
    			if(sub2 == 4) {//If the student takes only one subject
    				if(subjectNums[sub1] < groupNum) {
    					plan[subjectNums[sub1]][sub1] = keySort;
    					subjectNums[sub1] = subjectNums[sub1] + 1;
    					studentsTemp.remove(keySort);
    					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA1());
    				}else {//If the chosen subject is already full
    					unmatchedStudents.put(keySort, studentsTemp.get(keySort));
    					studentsTemp.remove(keySort);
    				}
    			}else {//If the student takes two subjects
    				int subjectIndex = random.nextInt(2);//Randomly choose between two subjects
    				if(subjectIndex == 0) {//Assign student to Subject 1
    					if(subjectNums[sub1] < groupNum) {
    						plan[subjectNums[sub1]][sub1] = keySort;
        					subjectNums[sub1] = subjectNums[sub1] + 1;
        					studentsTemp.remove(keySort);
        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA1());
    					}else if(subjectNums[sub2] < groupNum) {//If Subject 1 is full, choose Subject 2
    						plan[subjectNums[sub2]][sub2] = keySort;
        					subjectNums[sub2] = subjectNums[sub2] + 1;
        					studentsTemp.remove(keySort);
        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA2());
    					}else {//If both subjects are full, temporarily store student in another Map
    						unmatchedStudents.put(keySort, studentsTemp.get(keySort));
        					studentsTemp.remove(keySort);
    					}
    				}else if(subjectIndex == 1) {//Assign student to Subject 2
    					if(subjectNums[sub2] < groupNum) {
    						plan[subjectNums[sub2]][sub2] = keySort;
        					subjectNums[sub2] = subjectNums[sub2] + 1;
        					studentsTemp.remove(keySort);
        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA2());
    					}else if(subjectNums[sub1] < groupNum) {//If Subject 2 is full, choose Subject 1
    						plan[subjectNums[sub1]][sub1] = keySort;
        					subjectNums[sub1] = subjectNums[sub1] + 1;
        					studentsTemp.remove(keySort);
        					StoreUtils.students.get(keySort).setFinalGPA(StoreUtils.students.get(keySort).getGPA1());
    					}else {//If both subjects are full, temporarily store unmatched student in another Map
    						unmatchedStudents.put(keySort, studentsTemp.get(keySort));
        					studentsTemp.remove(keySort);
    					}
    				}
    			}
    		}
    		
    		int unmatchCount = unmatchedStudents.size();
    		
    		//Fit unmatched students into the grouping plan
    		for(int i = 0; i < unmatchCount; i++) {
    			
    			//Randomly find the key of an unmatched student
    			Integer[] keys = unmatchedStudents.keySet().toArray(new Integer[0]);
    			Integer keyUnmatch = keys[random.nextInt(keys.length)];
    			
    			//Assign this student to a subject that is not full
    			if(subjectNums[0] < groupNum) {//If Physics is not full, assign student to Physics
    				plan[subjectNums[0]][0] = keyUnmatch;
    				subjectNums[0] = subjectNums[0] + 1;
    				unmatchedStudents.remove(keyUnmatch);
    			}else if(subjectNums[1] < groupNum) {//If Chemistry is not full, assign student to Chemistry
    				plan[subjectNums[1]][1] = keyUnmatch;
    				subjectNums[1] = subjectNums[1] + 1;
    				unmatchedStudents.remove(keyUnmatch);
    			}else if(subjectNums[2] < groupNum) {//If Biology is not full, assign student to Biology
    				plan[subjectNums[2]][2] = keyUnmatch;
    				subjectNums[2] = subjectNums[2] + 1;
    				unmatchedStudents.remove(keyUnmatch);
    			}else if(subjectNums[3] < groupNum) {//If CS is not full, assign student to CS
    				plan[subjectNums[3]][3] = keyUnmatch;
    				subjectNums[3] = subjectNums[3] + 1;
    				unmatchedStudents.remove(keyUnmatch);
    			}
    			
    			//Use the higher GPA of the student for evaluation if the student takes two subjects
    			if(StoreUtils.students.get(keyUnmatch).getGPA1() > StoreUtils.students.get(keyUnmatch).getGPA2()) {
    				StoreUtils.students.get(keyUnmatch).setFinalGPA(StoreUtils.students.get(keyUnmatch).getGPA1());
    			}else{
    				StoreUtils.students.get(keyUnmatch).setFinalGPA(StoreUtils.students.get(keyUnmatch).getGPA2());
    			}
    		}
    		
    		//If there was one extra student taken out at the beginning
    		if(remainedStudents.size() == 1) {
    			
    			//Find the key of the extra student
    			Integer[] key = remainedStudents.keySet().toArray(new Integer[0]);
    			Integer keyRemain = key[0];
    			
    			if(groupNum == 0) {//If there is only 1 student entered into the system
    				plan[0][0] = keyRemain;
    				remainedStudents.remove(keyRemain);
    				groupNum = 1;
    			}else {
    				//Add the student to a group
        			plan[groupNum - 1][4] = keyRemain;
        			remainedStudents.remove(keyRemain);
    			}
    			
    			//Use the higher GPA of the student for evaluation if the student takes two subjects
    			if(StoreUtils.students.get(keyRemain).getGPA1() > StoreUtils.students.get(keyRemain).getGPA2()) {
    				StoreUtils.students.get(keyRemain).setFinalGPA(StoreUtils.students.get(keyRemain).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain).setFinalGPA(StoreUtils.students.get(keyRemain).getGPA2());
    			}
    		}
    		
    		//If there were two extra students taken out at the beginning
    		if(remainedStudents.size() == 2) {
    			
    			//Find the keys of the extra students
    			Integer[] keys = remainedStudents.keySet().toArray(new Integer[0]);
    			Integer keyRemain1 = keys[0];
    			Integer keyRemain2 = keys[1];
    			
    			if(groupNum == 0 || groupNum == 1) {//If there are 2 or 6 students
    				//Create a new group with only two students
    				plan[groupNum][0] = keyRemain1;
    				plan[groupNum][1] = keyRemain2;
    				remainedStudents.remove(keyRemain1);
    				remainedStudents.remove(keyRemain2);
    				groupNum = groupNum + 1;
    			}else {
    				//Add each student to a group
        			plan[groupNum - 2][4] = keyRemain1;
        			plan[groupNum - 1][4] = keyRemain2;
        			remainedStudents.remove(keyRemain1);
    				remainedStudents.remove(keyRemain2);
    			}

    			//Use the higher GPAs of the students for evaluation if they take two subjects
    			if(StoreUtils.students.get(keyRemain1).getGPA1() > StoreUtils.students.get(keyRemain1).getGPA2()) {
    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA2());
    			}
    			
    			if(StoreUtils.students.get(keyRemain2).getGPA1() > StoreUtils.students.get(keyRemain2).getGPA2()) {
    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA2());
    			}
    		}
    		
    		//If there were three extra students taken out at the beginning
    		if(remainedStudents.size() == 3) {
    			
    			//Find the keys of the extra students
    			Integer[] keys = remainedStudents.keySet().toArray(new Integer[0]);
    			Integer keyRemain1 = keys[0];
    			Integer keyRemain2 = keys[1];
    			Integer keyRemain3 = keys[2];
    			
    			//Create one new group of 3
    			plan[groupNum][0] = keyRemain1;
    			plan[groupNum][1] = keyRemain2;
    			plan[groupNum][2] = keyRemain3;
    			groupNum = groupNum + 1;
    			remainedStudents.remove(keyRemain1);
				remainedStudents.remove(keyRemain2);
				remainedStudents.remove(keyRemain3);
    			
    			//Use the higher GPA of each student for evaluation if they take two subjects
    			if(StoreUtils.students.get(keyRemain1).getGPA1() > StoreUtils.students.get(keyRemain1).getGPA2()) {
    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain1).setFinalGPA(StoreUtils.students.get(keyRemain1).getGPA2());
    			}
    			
    			if(StoreUtils.students.get(keyRemain2).getGPA1() > StoreUtils.students.get(keyRemain2).getGPA2()) {
    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain2).setFinalGPA(StoreUtils.students.get(keyRemain2).getGPA2());
    			}
    			
    			if(StoreUtils.students.get(keyRemain3).getGPA1() > StoreUtils.students.get(keyRemain3).getGPA2()) {
    				StoreUtils.students.get(keyRemain3).setFinalGPA(StoreUtils.students.get(keyRemain3).getGPA1());
    			}else{
    				StoreUtils.students.get(keyRemain3).setFinalGPA(StoreUtils.students.get(keyRemain3).getGPA2());
    			}
    		}
    		
    		int groupGPAAverage = 0;
    		
    		//Calculate and display the average GPA of each group
    		for(int i = 0; i < groupNum; i++) {
    			int groupGPASum = 0;
    			if(plan[i][4] == null && plan[i][3] != null) {
    				for(int j = 0; j < 4; j++) {
        				groupGPASum = groupGPASum + StoreUtils.students.get(plan[i][j]).getFinalGPA();
        			}
    				groupGPAAverage = groupGPASum / 4;
    			}else if(plan[i][4] == null && plan[i][3] == null) {
    				for(int j = 0; j < 3; j++) {
        				groupGPASum = groupGPASum + StoreUtils.students.get(plan[i][j]).getFinalGPA();
        			}
    				groupGPAAverage = groupGPASum / 3;
    			}else if(plan[i][4] != null) {
    				for(int j = 0; j < 5; j++) {
        				groupGPASum = groupGPASum + StoreUtils.students.get(plan[i][j]).getFinalGPA();
        			}
    				groupGPAAverage = groupGPASum / 5;
    			}else if(plan[i][2] == null) {
    				for(int j = 0; j < 2; j++) {
        				groupGPASum = groupGPASum + StoreUtils.students.get(plan[i][j]).getFinalGPA();
        			}
    				groupGPAAverage = groupGPASum / 2;
    			}else if(plan[i][1] == null) {
    				groupGPAAverage = StoreUtils.students.get(plan[i][0]).getFinalGPA();
    			}
    			
    			plan[i][5] = new Integer(groupGPAAverage);
    		}
    		
    		int groupPersAverage = 0;
    		
    		//Calculate and display the average Personality Index of each group
    		for(int i = 0; i < groupNum; i++) {
    			int groupPersSum = 0;
    			if(plan[i][4] == null && plan[i][3] != null) {
    				for(int j = 0; j < 4; j++) {
        				groupPersSum = groupPersSum + StoreUtils.students.get(plan[i][j]).getFinalPersonality();
        			}
    				groupPersAverage = groupPersSum / 4;
    			}else if(plan[i][4] == null && plan[i][3] == null) {
    				for(int j = 0; j < 3; j++) {
        				groupPersSum = groupPersSum + StoreUtils.students.get(plan[i][j]).getFinalPersonality();
        			}
    				groupPersAverage = groupPersSum / 3;
    			}else if(plan[i][4] != null) {
    				for(int j = 0; j < 5; j++) {
        				groupPersSum = groupPersSum + StoreUtils.students.get(plan[i][j]).getFinalPersonality();
        			}
    				groupPersAverage = groupPersSum / 5;
    			}else if(plan[i][2] == null) {
    				for(int j = 0; j < 2; j++) {
        				groupPersSum = groupPersSum + StoreUtils.students.get(plan[i][j]).getFinalPersonality();
        			}
    				groupPersAverage = groupPersSum / 2;
    			}else if(plan[i][1] == null) {
    				groupPersAverage = StoreUtils.students.get(plan[i][0]).getFinalPersonality();
    			}
    			
    			plan[i][6] = new Integer(groupPersAverage);
    		}
    		
    		//Calculate standard deviation of the groups' GPAs
    		double totalGPASD = 0;
    		int totalGPASum = 0;
    		double totalGPAAverage = 0;
    		double totalGPADeviation = 0;
    		int gpaTemp = 0;
    		for(int i = 0; i < groupNum; i++) {
    			gpaTemp = plan[i][5];
                totalGPASum = totalGPASum + gpaTemp;
            }
    		totalGPAAverage = totalGPASum / groupNum;
    		for(int i = 0; i < groupNum; i++) {
    			gpaTemp = plan[i][5];
                totalGPADeviation = totalGPADeviation + Math.pow((gpaTemp - totalGPAAverage), 2);
            }
    		totalGPASD = Math.sqrt(totalGPADeviation / groupNum);
    		
    		//Calculate standard deviation of the groups' Personality Indices
    		double totalPersSD = 0;
    		int totalPersSum = 0;
    		double totalPersAverage = 0;
    		double totalPersDeviation = 0;
    		int persTemp = 0;
    		for(int i = 0; i < groupNum; i++) {
    			persTemp = plan[i][5];
                totalPersSum = totalPersSum + persTemp;
            }
    		totalPersAverage = totalPersSum / groupNum;
    		for(int i = 0; i < groupNum; i++) {
    			persTemp = plan[i][5];
                totalPersDeviation = totalPersDeviation + Math.pow((persTemp - totalPersAverage), 2);
            }
    		totalPersSD = Math.sqrt(totalPersDeviation / groupNum);
    		
    		//Calculate 3 overall standard deviations according to 3 weightings
    		sd1 = (totalGPASD * 0.6) + (totalPersSD * 0.4);
    		sd2 = (totalGPASD * 0.85) + (totalPersSD * 0.15);
    		sd3 = (totalGPASD * 0.35) + (totalPersSD * 0.65);
    		
    		//Check if this generated plan is the first plan
    		if(StoreUtils.keyMinPlan1.intValue() == -1 || StoreUtils.keyMinPlan2.intValue() == -1 || StoreUtils.keyMinPlan3.intValue() == -1) {
    			StoreUtils.keyMinPlan1 = 0;
    			StoreUtils.keyMinPlan2 = 0;
    			StoreUtils.keyMinPlan3 = 0;
    			StoreUtils.plans.put(StoreUtils.keyMinPlan1, plan);
    			minSD1 = sd1;
    			minSD2 = sd2;
    			minSD3 = sd3;
    			planNum = 1;
    		}else {//If not, check if this plan has a smallest standard deviation in all plans. If yes, replace the previous best plan
    			if(sd1 < minSD1) {
    				StoreUtils.keyMinPlan1 = StoreUtils.plans.size();
    				minSD1 = sd1;
    			}
    			if(sd2 < minSD2) {
    				StoreUtils.keyMinPlan2 = StoreUtils.plans.size();
    				minSD2 = sd2;
    			}
    			if(sd3 < minSD3) {
    				StoreUtils.keyMinPlan3 = StoreUtils.plans.size();
    				minSD3 = sd3;
    			}
    			
    			//Check if the generated plan already exists. If not, add to collection
    			if(!StoreUtils.plans.containsValue(plan)) {
    				StoreUtils.plans.put(new Integer(StoreUtils.plans.size()), plan);
    				planNum = planNum + 1;
    			}
    		}
    		
    		plan = new Integer[groupNum + 1][7];
    		
    		if(stop) {
    			break;
    		}
    	}
    	
    
		
	}

}
