package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.R


data class CardItem(
    val id: String,
    val title: String,
    val bankName: String,
    val cardNumber: String,
    val balance: String
): MoneyAccountListForRV(MoneyAccountListForRV.CARD_ITEM_TYPE)

class CardItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemViewHolder {


    val txtTitle = itemView.findViewById<TextView>(R.id.txt_card_title)
    val txtBankName = itemView.findViewById<TextView>(R.id.txt_bank_name)
    val txtCardNumber = itemView.findViewById<TextView>(R.id.txt_card_number)
    val txtBalance = itemView.findViewById<TextView>(R.id.txt_header)


    override fun bindViews(moneyAccountListForRV: MoneyAccountListForRV) {
        val mItem = moneyAccountListForRV as CardItem
        txtTitle.text = mItem.title
        txtBankName.text = mItem.bankName
        txtCardNumber.text = mItem.cardNumber
        txtBalance.text = mItem.balance

    }


}