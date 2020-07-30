package com.example.roomrecyclerviewtest.Reposetories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.roomrecyclerviewtest.ConsumptionDataToGraph
import com.example.roomrecyclerviewtest.DataBase.Dao.AddTransactionDao
import com.example.roomrecyclerviewtest.DataBase.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.DataBase.Entity.*
import com.example.roomrecyclerviewtest.DataBase.MoneyAccountDataBase
//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MoneyAccountRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var moneyAccountDao: MoneyAccountDao
    private var addTransactionDao: AddTransactionDao?

    init {
        val db = MoneyAccountDataBase.getInstance(application)
        moneyAccountDao = db?.moneyAccountDao()
        addTransactionDao = db?.addTransactionDao()

    }


    suspend fun insertMoneyAccount(mItem: MoneyAccount){
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertMoneyAccount(mItem)
        }

    }

     fun getAllMoneyAccounts() : LiveData<List<MoneyAccount>> {

        return moneyAccountDao.getAllMoneyAccounts()



    }

    suspend fun getMoneyAccountById(id: String) : MoneyAccount? {

        return withContext(Dispatchers.IO) {
            val a = moneyAccountDao?.getMoneyAccountById(id)
            a

        }

    }

    suspend fun deleteMoneyAccountById(id: String){

        withContext(Dispatchers.IO) {
           moneyAccountDao?.deleteMoneyAccountById(id)


        }

    }

    suspend fun getConsumptionCategoryByMaxRating() : ConsumptionCategory? {

        return withContext(Dispatchers.IO) {
            val a =  moneyAccountDao?.getConsumptionCategoryByMaxRating()
            a

        }



    }

    suspend fun insertTransactionAndUpdateMoneyAccount(operation: Operation, moneyAccount: MoneyAccount) {

        withContext(Dispatchers.IO) {

            addTransactionDao?.insertOperationAndUpdateMoneyAccount(operation, moneyAccount)
        }
    }

    fun getAllOperations() = moneyAccountDao?.getAllOperations()

    suspend fun insertIncomeCategory(incomeCategory: IncomeCategory) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertIncomeCategory(incomeCategory)
        }

    }
    suspend fun insertConsumptionCategory(consumptionCategory: ConsumptionCategory) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertConsumptionCategory(consumptionCategory)
        }

    }

    fun getAllIncomeCategory() = moneyAccountDao?.getAllIncomeCategory()

    fun getAllConsumptionCategory() = moneyAccountDao?.getAllConsumptionCategory()

    suspend fun insertBank(bank: Bank) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertBank(bank)
        }

    }

    fun getDataToConsumptionGraph() = moneyAccountDao.getDataToConsumptionGraph()
    fun getDataToIncomeGraph() = moneyAccountDao.getDataToIncomeGraph()

    fun getBankList() = moneyAccountDao?.getBankList()

    fun getMoneyAccountList() = moneyAccountDao?.getMoneyAccountList()

//    suspend fun insertOperation(operation: Operation) {
//        withContext(Dispatchers.IO) {
//            moneyAccountDao?.insertOperation(operation)
//        }
//
//    }



}