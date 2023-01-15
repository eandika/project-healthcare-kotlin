package com.example.healthcare.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.healthcare.model.ModelDatabase

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_healthcare")
    fun getAllData(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabase: ModelDatabase)

    @Query("DELETE FROM tbl_healthcare WHERE uid= :uid")
    fun deleteDataById(uid: Int)
}