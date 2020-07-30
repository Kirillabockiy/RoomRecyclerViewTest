package com.example.roomrecyclerviewtest.Interfaces

//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.kirillabockiy.examplemvvmapp.Model.MoneyAccountListForRV

interface OnMoneyAccountClickListener {

    fun onMoneyAccountClickListener(moneyAccountListForRV: MoneyAccountListForRV)
//    fun onMoneyAccountLongClickListener(rvItemType: RVItemType)
}