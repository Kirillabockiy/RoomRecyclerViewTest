package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.R


data class CashItem(
    val id: String,
    val title: String,
    val balance: String
): RVItemType(RVItemType.CASH_ITEM_TYPE)

class CashItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemViewHolder {


    val textTitle = itemView.findViewById<TextView>(R.id.txt_cash_title)
    val textBalance = itemView.findViewById<TextView>(R.id.txt_cash_balance)

    override fun bindViews(rvItemType: RVItemType) {
        val mItem = rvItemType as CashItem
        textTitle.text = mItem.title
        textBalance.text = mItem.balance

    }


}
