/*
 * Copyright (c) 2022 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 1.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.indraazimi.galerihewan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Jumlah data: " + getData().size)
    }

    // Biasanya kita mengambil data dari database, atau server.
    // Tapi karena materi belum sampai, kita buat dummy saja.
    private fun getData(): List<Hewan> {
        return listOf(
                Hewan("Angsa", "Cygnus olor"),
                Hewan("Ayam", "Gallus gallus"),
                Hewan("Bebek", "Cairina moschata"),
                Hewan("Domba", "Ovis ammon"),
                Hewan("Kalkun", "Meleagris gallopavo"),
                Hewan("Kambing", "Capricornis sumatrensis"),
                Hewan("Kelinci", "Oryctolagus cuniculus"),
                Hewan("Kerbau", "Bubalus bubalis"),
                Hewan("Kuda", "Equus caballus"),
                Hewan("Sapi", "Bos taurus"),
        )
    }
}