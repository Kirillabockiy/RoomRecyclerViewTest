package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.DataBase.Entity.ConsumptionCategory
import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.Interfaces.CategoryItemViewHolderInterface
import com.example.roomrecyclerviewtest.Interfaces.ConsumptionCategoryItemViewHolderInterface
import com.example.roomrecyclerviewtest.R


data class CategoryItemConsumption(
    val title: String
)

class CategoryItemConsumptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    ConsumptionCategoryItemViewHolderInterface {


    val txtTitle = itemView.findViewById<TextView>(R.id.txt_consumption_category_item)



    override fun bindViews(item: ConsumptionCategory) {

        txtTitle.text = item.consumption_title


    }


}