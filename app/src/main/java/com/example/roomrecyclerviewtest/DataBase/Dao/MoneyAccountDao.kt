package com.example.roomrecyclerviewtest.DataBase.Dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomrecyclerviewtest.ConsumptionDataToGraph
import com.example.roomrecyclerviewtest.ConsumptionsFromMounts
import com.example.roomrecyclerviewtest.DataBase.Entity.*
import com.example.roomrecyclerviewtest.IncomeDataToGraph
//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.Models.CardMoneyAccount
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin

@Dao
interface MoneyAccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMoneyAccount(item: MoneyAccount)

    @Query("SELECT * from money_account_table ORDER BY account_type ASC")
    fun getAllMoneyAccounts(): LiveData<List<MoneyAccount>>

    @Query("SELECT id, title, account_type,  current_balance from money_account_table")
    fun getMoneyAccountList(): LiveData<List<MoneyAccountMin>>

    @Query("SELECT * from money_account_table WHERE id = :id")
    fun getMoneyAccountById(id: String): MoneyAccount


    @Query("SELECT * from consumption_category LIMIT 1")
    fun getConsumptionCategoryByMaxRating(): ConsumptionCategory

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOperation(operation: Operation)

    @Query("SELECT * from operation ORDER BY date_time DESC")
    fun getAllOperations(): LiveData<List<Operation>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIncomeCategory(incomeCategory: IncomeCategory)

    @Query("SELECT * from income_category")
    fun getAllIncomeCategory(): LiveData<List<IncomeCategory>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertConsumptionCategory(consumptionCategory: ConsumptionCategory)

    @Query("SELECT * from consumption_category ORDER BY consumption_title ASC")
    fun getAllConsumptionCategory(): LiveData<List<ConsumptionCategory>>


    @Query("DELETE FROM money_account_table WHERE id = :id" )
    fun deleteMoneyAccountById(id: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBank(bank: Bank)

    @Query("SELECT * from bank")
    fun getBankList(): LiveData<List<Bank>>


    @Query("SELECT SUM(summ) as summ, consumption_category FROM operation WHERE operation_type = 'CONSUMPTION_ITEM_TYPE' GROUP BY consumption_category")
    fun getDataToConsumptionGraph(): LiveData<List<ConsumptionDataToGraph>>

    @Query("SELECT SUM(summ) as summ, income_category FROM operation WHERE operation_type = 'INCOME_ITEM_TYPE' GROUP BY income_category")
    fun getDataToIncomeGraph(): LiveData<List<IncomeDataToGraph>>



}