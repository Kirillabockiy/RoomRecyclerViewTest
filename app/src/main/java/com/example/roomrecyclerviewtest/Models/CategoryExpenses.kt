package com.example.roomrecyclerviewtest.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "category_expenses_table")
data class CategoryExpenses (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "icon_id")
    var iconId: Int



)