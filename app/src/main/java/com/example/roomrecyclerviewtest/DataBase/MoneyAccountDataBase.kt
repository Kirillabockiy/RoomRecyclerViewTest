package com.example.roomrecyclerviewtest.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomrecyclerviewtest.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.Models.MoneyAccount


@Database(entities = [MoneyAccount::class], version = 1, exportSchema = false)
abstract class MoneyAccountDataBase : RoomDatabase() {

    abstract fun moneyAccountDao(): MoneyAccountDao

    companion object {

        @Volatile
        private var INSTANCE: MoneyAccountDataBase? = null

        fun getDataBase(context: Context): MoneyAccountDataBase? {
            if (INSTANCE == null) {

                synchronized(MoneyAccountDataBase::class.java) {
                    if (INSTANCE == null) {

                        INSTANCE= Room.databaseBuilder(
                            context.applicationContext,
                            MoneyAccountDataBase::class.java, "money_account_database"
                        )
                            .build()
                    }

                }
            }

            return INSTANCE
        }
    }

}