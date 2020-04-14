package com.example.roomrecyclerviewtest.Dao


import androidx.room.*
//import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.Models.CardMoneyAccount
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount

@Dao
interface MoneyAccountDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun setMoneyAccount(movie: MoneyAccount)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCardMoneyAccount(item: CardMoneyAccount)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCashMoneyAccount(item: CashMoneyAccount)

    @Query("DELETE FROM cash_money_account_table WHERE id = :id")
    fun deleteCashMoneyMoneyAccontById(id: String)

    @Query("DELETE FROM card_money_account_table WHERE id = :id")
    fun deleteCardMoneyMoneyAccontById(id: String)


//    @Delete
//    suspend fun deleteCashMoneyAccount(cashMoneyAccount: CashMoneyAccount)

//    @Query("SELECT * from money_account_table ORDER BY id ASC")
//    fun getMoneyAccounts(): LiveData<List<MoneyAccount>>

    @Query("SELECT * from card_money_account_table ORDER BY title ASC")
    fun getCardMoneyAccountsList(): List<CardMoneyAccount>

    @Query("SELECT * from cash_money_account_table ORDER BY title ASC")
    fun getCashMoneyAccountsList(): List<CashMoneyAccount>

//    @Query("DELETE FROM money_account_table")
//    fun deleteAllMoneyAccounts()
//
//    @Query("DELETE FROM money_account_table WHERE id = :id")
//    fun deleeteMoneyAccontById(id: Int)
//
//    @Query("SELECT * FROM money_account_table WHERE id =:id")
//    fun loadMoneyAccountById(id: Int): LiveData<MoneyAccount>
}