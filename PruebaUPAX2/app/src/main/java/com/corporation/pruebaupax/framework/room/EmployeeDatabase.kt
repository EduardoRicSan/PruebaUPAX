package com.corporation.pruebaupax.framework.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.corporation.pruebaupax.domain.entity.Employee
import com.corporation.pruebaupax.usecases.EmployeeDAO

/**
 * Singleton to create unique database instance
 */
@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun cemployeeDao(): EmployeeDAO

    companion object {
        private const val DATABASE_NAME = "score_database"
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase? {
            INSTANCE
                ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }

}

