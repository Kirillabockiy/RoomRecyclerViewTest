package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
import com.example.roomrecyclerviewtest.R

import com.kirillabockiy.examplemvvmapp.Model.*



class MultipleTypesAdapter (val context: Context,
                            var moneyAccountItemList: List<MoneyAccountListForRV>
                           ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val CARD_ITEM_TYPE = 1
        const val CASH_ITEM_TYPE = 2
        const val TARGET_ITEM_TYPE = 3
        const val DEFAULT = 666
    }


    private var calback: OnMoneyAccountClickListener? = null

    fun attachCalback(calback: OnMoneyAccountClickListener) {

        this.calback = calback
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (moneyAccountItemList[position].itemType) {
            MoneyAccountListForRV.HEADER_ITEM_TYPE -> HEADER_ITEM_TYPE
            MoneyAccountListForRV.CARD_ITEM_TYPE -> CARD_ITEM_TYPE
            MoneyAccountListForRV.CASH_ITEM_TYPE -> CASH_ITEM_TYPE
            MoneyAccountListForRV.TARGET_ITEM_TYPE -> TARGET_ITEM_TYPE

            else -> DEFAULT
        }
        return type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder = when (viewType) {
            HEADER_ITEM_TYPE -> HeaderItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.balance_header_item, parent, false))
            CARD_ITEM_TYPE -> CardItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.debet_card_item, parent, false))
            TARGET_ITEM_TYPE -> TargetItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.target_item, parent, false))
            else -> CashItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cash_item, parent, false))

        }
       return viewHolder
    }

    override fun getItemCount(): Int {
        return moneyAccountItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindViews(moneyAccountItemList[position])

        holder.itemView.setOnClickListener{calback?.onMoneyAccountClickListener(moneyAccountItemList[position])}
//        holder.itemView.setOnLongClickListener{calback?.onMoneyAccountLongClickListener(itemList[position])}
    }




}