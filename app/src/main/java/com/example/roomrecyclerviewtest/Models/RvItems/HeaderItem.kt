package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.R


data class HeaderItem(
    var text: String
): MoneyAccountListForRV(MoneyAccountListForRV.HEADER_ITEM_TYPE)


class HeaderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemViewHolder {


    val textView = itemView.findViewById<TextView>(R.id.txt_header)

    override fun bindViews(moneyAccountListForRV: MoneyAccountListForRV) {
        val mItem = moneyAccountListForRV as HeaderItem
        textView.text = mItem.text

    }


}




