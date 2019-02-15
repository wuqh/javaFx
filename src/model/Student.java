package model;

/**
 * Created by rockywoo on 2019/2/15.
 */
public class Student {

	private String name;
	private String gender;
	private String subject1;
	private String subject2;
	private String level1;
	private String level2;
	private double gpa1;
	private double gpa2;
	private int personality;
	private String assignedSub = null;
	
	public Student() {
		
	}
	
	public Student(String name, String gender, String subject1, String subject2, int gpa1, int gpa2, int personality) {
		this.name = name;
		this.gender = gender;
		this.subject1 = subject1;
		this.subject2 = subject2;
		//this.level1 = level1;
		//this.level2 = level2;
		this.gpa1 = gpa1;
		this.gpa2 = gpa2;
		this.personality = personality;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getSubject1() {
		return subject1;
	}
	
	public String getSubject2() {
		return subject2;
	}
	
	public String getLevel1() {
		return level1;
	}
	
	public String getLevel2() {
		return level2;
	}
	
	public double getGPA1() {
		return gpa1;
	}
	
	public double getGPA2() {
		return gpa2;
	}
	
	public int getPersonality() {
		return personality;
	}
	
	public void setAssignedSub(String aSubject) {
		assignedSub = aSubject;
	}
	
	public String getAssignedSub() {
		return assignedSub;
	}

	public double getGpa1() {
		return gpa1;
	}

	public void setGpa1(double gpa1) {
		this.gpa1 = gpa1;
	}

	public double getGpa2() {
		return gpa2;
	}

	public void setGpa2(double gpa2) {
		this.gpa2 = gpa2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public void setLevel2(String level2) {
		this.level2 = level2;
	}

	public void setPersonality(int personality) {
		this.personality = personality;
	}
	
	
}
