package com.example.roomrecyclerviewtest.Interfaces

import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory

interface CategoryItemViewHolderInterface {
    fun bindViews(title: IncomeCategory)

}