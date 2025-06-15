package com.example.travelapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travelapp.data.local.database.dao.AccountDao
import com.example.travelapp.data.local.entity.AccountEntity

@Database(
    entities = [AccountEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase(){

    abstract fun accountDao(): AccountDao

    companion object{
        const val DB_NAME = "travel_db"

        @Volatile
        private var instance: RoomDB? = null

        fun getDatabase(context: Context): RoomDB {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    DB_NAME
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }

}