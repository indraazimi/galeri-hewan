/*
 * Copyright (c) 2021 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 1.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.indraazimi.galerihewan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hewan")
data class HewanEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,
        val nama: String,
        val namaLatin: String,
        val imageId: String
)