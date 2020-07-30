package com.example.roomrecyclerviewtest.DataBase

//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomrecyclerviewtest.DataBase.Dao.AddTransactionDao
import com.example.roomrecyclerviewtest.DataBase.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.DataBase.Entity.*


@Database(
    entities = [
    MoneyAccount::class,
    Bank::class,
    Operation::class,
    IncomeCategory::class,
    ConsumptionCategory::class],
    version = 1,
    exportSchema = true
)

abstract class MoneyAccountDataBase : RoomDatabase() {

    abstract fun moneyAccountDao(): MoneyAccountDao
    abstract fun addTransactionDao(): AddTransactionDao

    companion object {

        @Volatile
        private var INSTANCE: MoneyAccountDataBase? = null

        fun getInstance(context: Context) :MoneyAccountDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                MoneyAccountDataBase::class.java, "money_account_database").build()

//                .createFromAsset("Database/MoneyAccountDB.db")


    }
}

