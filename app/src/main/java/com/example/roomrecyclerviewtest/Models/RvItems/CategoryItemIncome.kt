package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.Interfaces.CategoryItemViewHolderInterface
import com.example.roomrecyclerviewtest.R


data class CategoryItemIncome(
    val title: String
)

class CategoryItemIncomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    CategoryItemViewHolderInterface {


    val txtTitle = itemView.findViewById<TextView>(R.id.txt_category_item)



    override fun bindViews(item: IncomeCategory) {

        txtTitle.text = item.income_title


    }


}