package com.example.simion.myapplication;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RideDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Ride ride);


    @Delete
    void delete(Ride ride);

    @Query("SELECT users.name FROM users WHERE id = :id")
    String getNameUser(int id);


    @Query("SELECT * FROM rides")
    List<Ride> getRides();

    @Query("SELECT * FROM rides")
    LiveData<List<Ride>> getAllRides();
}
