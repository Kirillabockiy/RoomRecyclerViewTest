package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.IncomeItemViewHolderBind
import com.example.roomrecyclerviewtest.R
import java.text.SimpleDateFormat
import java.util.*


data class IncomeItem(
    val id: String,
    val incomeCategory: String,
    val toAccount: String,
    val summ: String,
    val dateMillis: Long
): RVOperationItemType(RVOperationItemType.INCOME_ITEM_TYPE)

class IncomeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    IncomeItemViewHolderBind {


    val incomeCategory = itemView.findViewById<TextView>(R.id.txt_income_category)
    val toAccount = itemView.findViewById<TextView>(R.id.txt_income_from_money_account)
    val summ = itemView.findViewById<TextView>(R.id.txt_income_operation_summ)
    val date = itemView.findViewById<TextView>(R.id.txt_date_time_operation_income)


    override fun bindViews(rvOperationItemType: RVOperationItemType) {
        val mItem = rvOperationItemType as IncomeItem
        incomeCategory.text = mItem.incomeCategory
        toAccount.text = mItem.toAccount
        summ.text = mItem.summ
        date.text = Date(mItem.dateMillis).toString()
    }


}