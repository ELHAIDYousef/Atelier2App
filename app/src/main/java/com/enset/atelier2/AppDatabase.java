package com.enset.atelier2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Reclamation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReclamationDao reclamationDao();
}