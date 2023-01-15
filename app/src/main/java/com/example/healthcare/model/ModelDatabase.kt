package com.example.healthcare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_healthcare")
class ModelDatabase : java.io.Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid = 0

    @ColumnInfo(name = "nama_pasien")
    lateinit var namaPasien: String

    @ColumnInfo(name = "jenis_kelamin")
    lateinit var jenisKelamin: String

    @ColumnInfo(name = "usia")
    lateinit var usia: String

    @ColumnInfo(name = "nama_dokter")
    lateinit var namaDokter: String

    @ColumnInfo(name = "tanggal")
    lateinit var tanggal: String

    @ColumnInfo(name = "jam")
    lateinit var jam: String
}