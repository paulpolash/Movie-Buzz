package com.example.moviebuzz.data.local.movies

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDatabase : RoomDatabase(){
//    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE : MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}