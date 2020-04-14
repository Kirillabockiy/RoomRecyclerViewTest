package com.example.roomrecyclerviewtest.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "card_money_account_table")
data class CardMoneyAccount(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "bank_name")
    var bankName: String,

    @ColumnInfo(name = "card_number")
    var cardNumber: String,

    @ColumnInfo(name = "balance")
    var balance: String
)