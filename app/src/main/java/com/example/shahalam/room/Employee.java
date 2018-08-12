package com.example.shahalam.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Employee_table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String salary;
    private String age;
    private String designation;

    public Employee(String name, String salary, String age, String designation) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
