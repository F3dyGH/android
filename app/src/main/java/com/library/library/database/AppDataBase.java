package com.library.library.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.library.library.Entity.User;
import com.library.library.DAO.UserDAO;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public static final String local_db_name = "library_db";
    private static AppDataBase instance;

    public abstract UserDAO userDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, AppDataBase.local_db_name)
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}
