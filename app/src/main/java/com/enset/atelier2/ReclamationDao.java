package com.enset.atelier2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReclamationDao {

    @Insert
    void ajouter(Reclamation reclamation);

    @Query("SELECT * FROM reclamations ORDER BY id DESC")
    List<Reclamation> getAll();

    @Update
    void modifier(Reclamation reclamation);

    @Delete
    void supprimer(Reclamation reclamation);
}