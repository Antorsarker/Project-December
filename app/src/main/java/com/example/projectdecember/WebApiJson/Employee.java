package com.example.projectdecember.WebApiJson;

import com.google.gson.annotations.SerializedName;

public class Employee {

//    private int id;
//    private String name;
//    private String salary;
//    private String age;
//    private String profilePicture;
//
//    public Employee(int id, String name, String salary, String age, String profilePicture) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//        this.age = age;
//        this.profilePicture = profilePicture;
//    }
//
//    public Employee() {
//
//    }
//
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSalary() {
//        return salary;
//    }
//
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(String profilePicture) {
//        this.profilePicture = profilePicture;
//    }

    @SerializedName("id")
    public String id;
    @SerializedName("employee_name")
    public String name;
    @SerializedName("employee_salary")
    public String salary;
    @SerializedName("employee_age")
    public String age;
    @SerializedName("profile_image")
    public String profilePicture;

}
