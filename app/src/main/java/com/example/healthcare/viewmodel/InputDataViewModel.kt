package com.example.healthcare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.healthcare.database.DatabaseClient.Companion.getInstance
import com.example.healthcare.database.dao.DatabaseDao
import com.example.healthcare.model.ModelDatabase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class InputDataViewModel(application: Application) : AndroidViewModel(application) {
    var databaseDao: DatabaseDao?

    fun addDataJanji(
        nama_pasien: String, jenis_kelamin: String, usia: String,
        nama_dokter: String, tanggal: String, jam: String
    ) {
        Completable.fromAction {
            val modelDatabase = ModelDatabase()
            modelDatabase.namaPasien = nama_pasien
            modelDatabase.jenisKelamin = jenis_kelamin
            modelDatabase.usia = usia
            modelDatabase.namaDokter = nama_dokter
            modelDatabase.tanggal = tanggal
            modelDatabase.jam = jam
            databaseDao?.insertData(modelDatabase)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        databaseDao = getInstance(application)?.appDatabase?.databaseDao()
    }
}