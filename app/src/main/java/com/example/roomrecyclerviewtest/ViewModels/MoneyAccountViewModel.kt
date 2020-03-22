package com.example.roomrecyclerviewtest.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository
import kotlinx.coroutines.Job

class MoneyAccountViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: MoneyAccountRepository = MoneyAccountRepository(application)

    fun getMoneyAccounts() = repository.getMoneyAccounts()
//
    fun setMoneyAccount(moneyAccount: MoneyAccount) { repository.setMoneyAccount(moneyAccount)}
    fun deleteAllMoneyAccounts() { repository.deleteAllMoneyAccounts()}

    fun loadmoneyAccountbyId(id: Int) = repository.loadMoneyAccountbyId(id)






}