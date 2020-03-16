package com.example.roomrecyclerviewtest.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomrecyclerviewtest.Models.MoneyAccount

@Dao
interface MoneyAccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMoneyAccount(movie: MoneyAccount)

    @Query("SELECT * from money_account_table ORDER BY id ASC")
    fun getMoneyAccounts(): LiveData<List<MoneyAccount>>

    @Query("DELETE FROM money_account_table")
    fun deleteAllMoneyAccounts()

    @Query("DELETE FROM money_account_table WHERE id = :id")
    fun deleeteMoneyAccontById(id: Int)

    @Query("SELECT * FROM money_account_table WHERE id =:id")
    fun loadMoneyAccountById(id: Int): MoneyAccount
}