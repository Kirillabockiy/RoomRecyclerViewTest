package com.example.roomrecyclerviewtest.DataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "consumption_category")
data class ConsumptionCategory (

    @PrimaryKey
    val consumption_title: String

)