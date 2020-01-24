package com.example.homework_6.Model

import io.realm.RealmConfiguration
import io.realm.annotations.RealmModule

@RealmModule(classes = [Note::class])
internal object RealmConfig {

    fun provideDefaultConfiguration() : RealmConfiguration =
        RealmConfiguration.Builder()
            .name("noteDatabase.realm")
            .schemaVersion(1)
            .modules(RealmConfig)
            .deleteRealmIfMigrationNeeded().build()
}