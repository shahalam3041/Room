package com.example.shahalam.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name, age, salary, designation;
    Button save, show;
    String nameValue,ageValue,salaryValue,designationValue;
    TextView textView;
    private static final String TAG = "Employee log";
    EmployeeDao employeeDao;
    EmployeeDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        salary = findViewById(R.id.salary);
        designation = findViewById(R.id.designation);
        save = findViewById(R.id.saveBtn);
        show = findViewById(R.id.showBtn);
        textView = findViewById(R.id.textView);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nameValue = name.getText().toString();
                 ageValue = age.getText().toString();
                 salaryValue = salary.getText().toString();
                 designationValue = designation.getText().toString();

                database = EmployeeDatabase.getDatabase(MainActivity.this);

                Employee employee1 = new Employee(nameValue,salaryValue,ageValue,designationValue);

                database.employeeDao().insert(employee1);
                name.setText("");
                age.setText("");
                salary.setText("");
                designation.setText("");
                Toast.makeText(MainActivity.this,"Record Saved",Toast.LENGTH_SHORT).show();

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee>  employeeList = database.employeeDao().getEmployeeList();
                String listEmployee = "";
                for (Employee employee: employeeList)
                {
                    listEmployee = listEmployee + (employee.getName() + "\n");
                    textView.setText(listEmployee);
                }
            }
        });
    }
}
