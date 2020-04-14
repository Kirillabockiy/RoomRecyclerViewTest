package com.example.roomrecyclerviewtest.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "cash_money_account_table")
 class CashMoneyAccount(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "balance")
    var balance: String
)


