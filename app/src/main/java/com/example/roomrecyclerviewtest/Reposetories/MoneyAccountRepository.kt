package com.example.roomrecyclerviewtest.Reposetories

import android.app.Application
import com.example.roomrecyclerviewtest.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.DataBase.MoneyAccountDataBase
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    fun deleteAllMoneyAccounts() {
        launch { deleteAllMoneyAccountsBG() }

    }

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