package com.sodiqjon.simpletestapp.di

import android.app.Application
import com.orhanobut.hawk.Hawk
import  io.realm.Realm
import io.realm.RealmConfiguration


class RealmApp : Application() {
    private var config: RealmConfiguration? = null

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        Realm.init(this)
        config = RealmConfiguration.Builder()
            .name("userData.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        config.let { Realm.setDefaultConfiguration(it) }
    }
}