/*
 * Copyright (c) 2021 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 1.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.indraazimi.galerihewan.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indraazimi.galerihewan.model.Hewan

@Dao
interface HewanDao {

    @Insert
    fun insertAll(hewan: List<HewanEntity>)

    @Query("SELECT * FROM hewan")
    fun getHewan(): LiveData<List<Hewan>>

    @Query("DELETE FROM hewan")
    fun clearData()
}