package model;

public class Student {

	private String name;
	private String gender;
	private String subject1;
	private String subject2;
	//private String level1;
	//private String level2;
	private int gpa1;
	private int gpa2;
	//private int personality;
	//private String assignedSub = null;
	private int finalGPA = -1;
	private int finalPersonality;
	
	public Student() {
		
	}
	
	public Student(String name, String gender, String subject1, String subject2, int gpa1, int gpa2, int finalPersonality) {
		this.name = name;
		this.gender = gender;
		this.subject1 = subject1;
		this.subject2 = subject2;
		//this.level1 = level1;
		//this.level2 = level2;
		this.gpa1 = gpa1;
		this.gpa2 = gpa2;
		this.finalPersonality = finalPersonality;
		finalGPA = 0;
		finalPersonality = 0;
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
	
	/*public String getLevel1() {
		return level1;
	}
	
	public String getLevel2() {
		return level2;
	}*/
	
	public int getGPA1() {
		return gpa1;
	}
	
	public int getGPA2() {
		return gpa2;
	}
	
	/*public int getPersonality() {
		return personality;
	}*/
	
	public int getFinalGPA() {
		return finalGPA;
	}
	
	public int getFinalPersonality() {
		return finalPersonality;
	}
	
	/*public void setAssignedSub(String aSubject) {
		assignedSub = aSubject;
	}
	
	public String getAssignedSub() {
		return assignedSub;
	}*/

	/*public double getGpa1() {
		return gpa1;
	}*/

	public void setGPA1(int gpa1) {
		this.gpa1 = gpa1;
	}

	/*public double getGpa2() {
		return gpa2;
	}*/

	public void setGPA2(int gpa2) {
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

	/*public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public void setLevel2(String level2) {
		this.level2 = level2;
	}*/

	/*public void setPersonality(int personality) {
		this.personality = personality;
	}*/
	
	public void setFinalGPA(int gpa) {
		finalGPA = gpa;
	}
	
	public void setFinalPersonality(int personality) {
		finalPersonality = personality;
	}
}
