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
import com.indraazimi.galerihewan.util.MyTimer

class MainActivity : AppCompatActivity() {

    private lateinit var myTimer: MyTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTimer = MyTimer()
        Log.i("MainActivity", "onCreate dipanggil.")
    }

    override fun onStart() {
        super.onStart()
        myTimer.startTimer()
        Log.i("MainActivity", "onStart dipanggil.")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume dipanggil.")
    }

    override fun onPause() {
        Log.i("MainActivity", "onPause dipanggil.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("MainActivity", "onStop dipanggil.")
        myTimer.stopTimer()
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("MainActivity", "onDestroy dipanggil.")
        super.onDestroy()
    }
}