package com.example.roomrecyclerviewtest.Reposetories

import android.app.Application
import com.example.roomrecyclerviewtest.Dao.MoneyAccountDao
import com.example.roomrecyclerviewtest.DataBase.MoneyAccountDataBase
//import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.Models.CardMoneyAccount
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount
import com.kirillabockiy.examplemvvmapp.Model.TargetItem
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

    suspend fun insertCardMoneyAccount(mCardItem: CardMoneyAccount){
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertCardMoneyAccount(mCardItem)
        }

    }

    suspend fun insertCashMoneyAccount(mCashItem: CashMoneyAccount){
        withContext(Dispatchers.IO) {
            moneyAccountDao?.insertCashMoneyAccount(mCashItem)
        }

    }

    suspend fun deleteCashMoneyAccount(id: String) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.deleteCashMoneyMoneyAccontById(id)
        }

    }

    suspend fun deleteCardMoneyAccount(id: String) {
        withContext(Dispatchers.IO) {
            moneyAccountDao?.deleteCardMoneyMoneyAccontById(id)
        }

    }

    suspend fun getCashMoneyAccountList() : List<CashMoneyAccount>? {
        return withContext(Dispatchers.IO) {
            val cashMoneyAccountList = moneyAccountDao?.getCashMoneyAccountsList()
            cashMoneyAccountList
        }

    }

    suspend fun getCardMoneyAccountList() : List<CardMoneyAccount>? {
        return withContext(Dispatchers.IO) {
            val  cardmoneyAccountList = moneyAccountDao?.getCardMoneyAccountsList()
            cardmoneyAccountList
        }

    }



}