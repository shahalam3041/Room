package com.example.shahalam.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Employee.class} , version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();
    private static EmployeeDatabase databaseInstance;

    static EmployeeDatabase getDatabase(final Context context){

        if (databaseInstance==null)
        {
            synchronized (EmployeeDatabase.class) {
                if (databaseInstance==null) {
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext(),EmployeeDatabase.class,"Employee_Database").allowMainThreadQueries().build();
                }
            }
        }
        return databaseInstance;
    }
}
