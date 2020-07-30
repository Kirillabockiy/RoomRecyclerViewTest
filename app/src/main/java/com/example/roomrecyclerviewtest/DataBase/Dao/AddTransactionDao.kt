package com.example.roomrecyclerviewtest.DataBase.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import androidx.room.Update
import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.DataBase.Entity.Operation


@Dao
abstract class AddTransactionDao {

    @Insert
    abstract fun insertOperation(operation: Operation)

    @Update
    abstract fun updateMoneyAccount(moneyAccount: MoneyAccount)



    @Transaction
    open fun insertOperationAndUpdateMoneyAccount(operation: Operation, moneyAccount: MoneyAccount) {

        insertOperation(operation)
        updateMoneyAccount(moneyAccount)
    }


}