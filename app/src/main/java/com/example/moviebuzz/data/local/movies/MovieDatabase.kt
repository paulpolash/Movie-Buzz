package com.example.moviebuzz.data.local.movies

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviebuzz.data.model.MovieDbData

@Database(
    entities = [MovieDbData::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao

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