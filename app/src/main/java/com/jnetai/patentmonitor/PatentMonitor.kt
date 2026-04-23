package com.jnetai.patentmonitor

import android.app.Application
import com.jnetai.patentmonitor.data.PatentMonitorDatabase

class PatentMonitor : Application() {
    val database by lazy { PatentMonitorDatabase.getInstance(this) }
}