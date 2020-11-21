package com.mvvm.sample.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvm.sample.data.source.local.converters.DateConverter
import com.mvvm.sample.data.source.local.converters.ListConverter
import com.mvvm.sample.data.source.local.entities.*

@Database(
    entities = [
        UserEntity::class,
        AddressEntity::class,
        CompanyEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    DateConverter::class,
    ListConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserEntityDao(): UserEntityDao
    abstract fun getAddressEntityDao(): AddressEntityDao
    abstract fun getCompanyEntityDao(): CompanyEntityDao

    companion object {
        var TEST_MODE = false

        private const val DB_NAME = "mvvm-sample.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): AppDatabase {
            return if (TEST_MODE) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, DB_NAME
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            } else {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, DB_NAME
                ).build()
            }
        }
    }
}

