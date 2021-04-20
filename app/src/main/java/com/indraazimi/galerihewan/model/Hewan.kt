/*
 * Copyright (c) 2021 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 1.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.indraazimi.galerihewan.model

import com.indraazimi.galerihewan.R

data class Hewan(
        val nama: String,
        val namaLatin: String,
        val imageResId: Int = R.drawable.angsa
        // Untuk saat ini kita pakai gambar default saja dulu.
        // Gambar akan diambil dari internet di langkah selanjutnya.
)