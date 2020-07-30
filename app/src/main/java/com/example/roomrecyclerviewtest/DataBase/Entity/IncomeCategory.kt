package com.example.roomrecyclerviewtest.DataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "income_category")
data class IncomeCategory (

    @PrimaryKey
    val income_title: String

)