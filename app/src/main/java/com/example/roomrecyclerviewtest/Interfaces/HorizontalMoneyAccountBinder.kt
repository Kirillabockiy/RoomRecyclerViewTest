package com.example.roomrecyclerviewtest.Interfaces

import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin

interface HorizontalMoneyAccountBinder {
    fun bindViews(item: MoneyAccountMin)
}