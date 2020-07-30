package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.IncomeItemViewHolderBind
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
import com.example.roomrecyclerviewtest.R

import com.kirillabockiy.examplemvvmapp.Model.*



class OperationItemListAdapter (val context: Context,
                                var itemList: List<RVOperationItemType>
                           ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val INCOME_ITEM_TYPE = 1
        const val CONSUMPTION_ITEM_TYPE = 2
        const val TRANSFER_ITEM_TYPE = 3

        const val DEFAULT = 666
    }


    private var calback: OnMoneyAccountClickListener? = null

    fun attachCalback(calback: OnMoneyAccountClickListener) {

        this.calback = calback
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (itemList[position].itemType) {
            RVOperationItemType.HEADER_ITEM_TYPE -> HEADER_ITEM_TYPE
            RVOperationItemType.INCOME_ITEM_TYPE -> INCOME_ITEM_TYPE
            RVOperationItemType.CONSUMPTION_ITEM_TYPE -> CONSUMPTION_ITEM_TYPE
            RVOperationItemType.TRANSFER_ITEM_TYPE -> TRANSFER_ITEM_TYPE


            else -> DEFAULT
        }
        return type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder = when (viewType) {
            HEADER_ITEM_TYPE -> HeaderItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.balance_header_item, parent, false))
            INCOME_ITEM_TYPE -> IncomeItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.operation_income_item, parent, false))
            CONSUMPTION_ITEM_TYPE -> ConsumptionItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.operation_consumption_item, parent, false))
            else -> IncomeItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.operation_consumption_item, parent, false))

        }
       return viewHolder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as IncomeItemViewHolderBind).bindViews(itemList[position])

//        holder.itemView.setOnClickListener{calback?.onMoneyAccountClickListener(itemList[position])}
////        holder.itemView.setOnLongClickListener{calback?.onMoneyAccountLongClickListener(itemList[position])}
    }




}