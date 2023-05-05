/*
 * Copyright (c) 2022 Indra Azimi. All rights reserved.
 *
 * Dibuat untuk kelas Pemrograman untuk Perangkat Bergerak 1.
 * Dilarang melakukan penggandaan dan atau komersialisasi,
 * sebagian atau seluruh bagian, baik cetak maupun elektronik
 * terhadap project ini tanpa izin pemilik hak cipta.
 */

package com.indraazimi.galerihewan.network

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.indraazimi.galerihewan.MainActivity
import com.indraazimi.galerihewan.R


class UpdateWorker(
    context: Context,
    workerParams: WorkerParameters,
) : Worker(context, workerParams) {

    private val notificationId = 44

    override fun doWork(): Result {
        // Update data di background dilakukan dalam 3 tahapan:
        // 1. Request data yang baru ke server
        // 2. Simpan di database sebagai cache
        // 3. Beri tahu pengguna ada data baru

        // Langkah 1 dan 2 sudah diajarkan di modul sebelumnya.
        // Jadi di sini kita langsung loncat ke langkah 3 saja.

        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        // mengecek PendingIntent Mutable jika berjalan pada android 12+
        val pendingIntent = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            PendingIntent.getActivity(applicationContext, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)
        } else {
            PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        // pengecekan jika izin notifikasi di izinkan pengguna (pass exception securitycheck android 12+)
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // jika berulangkali tidak memberikan izin akan menampilkan dialog
            // dialog untuk mengiizinkan izin notifikasi secara manual
            val packageName = applicationContext.packageName
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:$packageName")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(intent)

            // jika izin tidak diizinkan, maka akan mengembalikan result gagal
            // dan notifikasi tidak berjalan
            return Result.failure()
        }

        // jika izin notifikasi diterima akan melakukan tugas yang ada dibawah ini

        val builder = NotificationCompat.Builder(applicationContext, MainActivity.CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(applicationContext.getString(R.string.notif_title))
            .setContentText(applicationContext.getString(R.string.notif_text))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        val manager = NotificationManagerCompat.from(applicationContext)

        manager.notify(notificationId, builder.build())

        return Result.success()
    }
}