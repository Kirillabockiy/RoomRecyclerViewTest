package com.example.roomrecyclerviewtest.Reposetories

import android.app.Application
import com.example.roomrecyclerviewtest.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.DataBase.MoneyAccountDataBase
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MoneyAccountRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var moneyAccountDao: MoneyAccountDao?


    init {
        val db = MoneyAccountDataBase.getDataBase(application)
        moneyAccountDao = db?.moneyAccountDao()

    }

    fun getMoneyAccounts() = moneyAccountDao?.getMoneyAccounts()

    fun loadMoneyAccountbyId(id: Int) = moneyAccountDao?.loadMoneyAccountById(id)

//    fun loadMoneyAccountbyId(id: Int): MoneyAccount? {
//
//
//        var item: MoneyAccount? = null
//
//        GlobalScope.launch() {
//            item = loadMoneyAccountBG(id)
//
//             }
//
//
//        return item
//    }

    fun deleteAllMoneyAccounts() {


        launch { deleteAllMoneyAccountsBG() }

    }

//    private suspend fun loadMoneyAccountBG(id: Int): MoneyAccount? {
//
//         var item: MoneyAccount? = null
//         withContext(Dispatchers.IO) {
//            item = moneyAccountDao?.loadMoneyAccountById(id)
//
//        }
//
//        return item
//
//
//    }

    fun setMoneyAccount(moneyAccount: MoneyAccount) {
        launch { setMoneyAccountBG(moneyAccount) }

    }

    private suspend fun setMoneyAccountBG(moneyAccount: MoneyAccount) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.setMoneyAccount(moneyAccount)

        }

    }

    private suspend fun deleteAllMoneyAccountsBG() {
         withContext(Dispatchers.IO) {
            moneyAccountDao?.deleteAllMoneyAccounts()

        }

    }


}