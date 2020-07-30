package com.example.roomrecyclerviewtest.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "money_account_table")
data class MoneyAccount(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "account_type")
    var accountType: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "bank_name")
    var bank_name: String,

    @ColumnInfo(name = "card_number")
    var card_number: String,

    @ColumnInfo(name = "currency")
    var currency: String,

    @ColumnInfo(name = "current_balance")
    var current_balance: String,

    @ColumnInfo(name = "target_balance")
    var target_balance: String,

    @ColumnInfo(name = "is_overal_balance")
    var is_overal_balance: Boolean


)