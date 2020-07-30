package com.example.roomrecyclerviewtest.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "operation")
data class Operation(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "operation_type")
    val operation_type: String,

    @ColumnInfo(name = "income_category")
    val income_category: String,

    @ColumnInfo(name = "consumption_category")
    val consumption_category: String,

    @ColumnInfo(name = "to_account_title")
    val to_account_title: String,

    @ColumnInfo(name = "to_account_id")
    val to_account_id: String,

    @ColumnInfo(name = "from_account_title")
    val from_account_title: String,

    @ColumnInfo(name = "from_account_id")
    val from_account_id: String,

    @ColumnInfo(name = "summ")
    val summ: Int,

    @ColumnInfo(name = "date_time")
    val date_time: Long


)