package com.example.shahalam.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee emp);

    @Query("Delete from Employee_table")
    void deleteAllEmployee();

    @Query("Select * from Employee_table order by name ASC")
    List<Employee> getEmployeeList();
}
