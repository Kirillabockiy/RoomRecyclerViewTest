package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.IncomeItemViewHolderBind
import com.example.roomrecyclerviewtest.R
import java.text.SimpleDateFormat
import java.util.*


data class ConsumptionItem(
    val id: String,
    val consumptionCategory: String,
    val fromAccount: String,
    val summ: String,
    val dateMillis: Long
): RVOperationItemType(RVOperationItemType.CONSUMPTION_ITEM_TYPE)

class ConsumptionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    IncomeItemViewHolderBind {


    val consumptionCategory = itemView.findViewById<TextView>(R.id.txt_consumption_category)
    val fromAccount = itemView.findViewById<TextView>(R.id.txt_consumption_from_money_account)
    val summ = itemView.findViewById<TextView>(R.id.txt_consumption_operation_summ)
    val date = itemView.findViewById<TextView>(R.id.txt_date_time_operation_consumption)


    override fun bindViews(rvOperationItemType: RVOperationItemType) {
        val mItem = rvOperationItemType as ConsumptionItem
        consumptionCategory.text = mItem.consumptionCategory
        fromAccount.text = mItem.fromAccount
        summ.text = mItem.summ
        date.text = Date(mItem.dateMillis).toString()
    }


}