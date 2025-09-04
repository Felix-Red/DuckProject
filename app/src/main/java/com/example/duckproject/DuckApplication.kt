package com.example.duckproject

import android.app.Application
import com.example.duckproject.data.ApplicationContainer
import com.example.duckproject.data.DefaultApplicationContainer

class DuckApplication: Application() {
    lateinit var container: ApplicationContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }
}