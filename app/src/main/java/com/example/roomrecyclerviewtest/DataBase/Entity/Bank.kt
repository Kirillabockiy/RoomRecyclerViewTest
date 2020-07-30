package com.example.roomrecyclerviewtest.DataBase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bank")
data class Bank(


    @PrimaryKey()
    var bank_name: String



)