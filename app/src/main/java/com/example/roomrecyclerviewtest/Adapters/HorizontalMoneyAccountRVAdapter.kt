package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Helper.IDTypeMoneyAccount
import com.example.roomrecyclerviewtest.Interfaces.HorizontalMoneyAccountBinder
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountHorizontalRVClickListener
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin
import com.example.roomrecyclerviewtest.R

class HorizontalMoneyAccountRVAdapter (val context: Context,
                                       var itemList: List<MoneyAccountMin>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var calback: OnMoneyAccountHorizontalRVClickListener? = null

    fun attachCalback(calback: OnMoneyAccountHorizontalRVClickListener) {

        this.calback = calback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HorizontalMoneyAccountViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.money_account_horizontal_item, parent, false))
    }

    override fun getItemCount(): Int {

        return itemList.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as HorizontalMoneyAccountViewHolder).bindViews(itemList[position])

        holder.itemView.setOnClickListener{calback?.onMoneyAccountHorizontalRVClick(itemList[position])}

    }
}

class HorizontalMoneyAccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), HorizontalMoneyAccountBinder {

    val txtTitleMoneyAccount = itemView.findViewById<TextView>(R.id.money_account_horizontal_txt_title)
    val iconMoneyAccount = itemView.findViewById<ImageView>(R.id.money_account_horizontal_icon)
    val cardViewHorizontalMoneyAccountItem = itemView.findViewById<CardView>(R.id.card_view_horizontal_money_account_item)
    override fun bindViews(item: MoneyAccountMin) {
        txtTitleMoneyAccount.text = item.title

        val iconId : Int = when(item.account_type) {

            IDTypeMoneyAccount.TYPE_CARD_MONEY_ACCOUNT -> R.drawable.ic_credit_card
            IDTypeMoneyAccount.TYPE_CASH_MONEY_ACCOUNT -> R.drawable.ic_account_balance_wallet
            IDTypeMoneyAccount.TYPE_BANK_MONEY_ACCOUNT -> R.drawable.ic_bank_account
            IDTypeMoneyAccount.TYPE_TARGET_MONEY_ACCOUNT -> R.drawable.ic_target

            else -> R.drawable.ic_credit_card
        }

        iconMoneyAccount.setImageResource(iconId)

//        itemView.setOnClickListener(View.OnClickListener {
//
//
//        })

    }


}