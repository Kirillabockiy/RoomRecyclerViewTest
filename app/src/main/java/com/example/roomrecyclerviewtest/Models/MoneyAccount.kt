package com.example.roomrecyclerviewtest.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "money_account_table")
data class MoneyAccount(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "name")
    var name: String,


    @ColumnInfo(name = "account_type")
    var accountType: String,

    @ColumnInfo(name = "current_balance")
    var currentBalance: String



)