package model;

/**
 * Created by rockywoo on 2019/2/15.
 */
public class Student {

    private String name;
    private String gender;
    private String first_subject_gpa_value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_subject_gpa_value() {
        return first_subject_gpa_value;
    }

    public void setFirst_subject_gpa_value(String first_subject_gpa_value) {
        this.first_subject_gpa_value = first_subject_gpa_value;
    }
}
