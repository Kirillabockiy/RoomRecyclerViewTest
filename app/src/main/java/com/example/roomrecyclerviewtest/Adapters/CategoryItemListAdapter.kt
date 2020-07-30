package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.R

import com.kirillabockiy.examplemvvmapp.Model.*



class CategoryItemListAdapter (val context: Context,
                               var itemList: List<IncomeCategory>
                           ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val CARD_ITEM_TYPE = 1
        const val CASH_ITEM_TYPE = 2
        const val TARGET_ITEM_TYPE = 3
        const val DEFAULT = 666
    }


//    private var calback: OnMoneyAccountClickListener? = null
//
//    fun attachCalback(calback: OnMoneyAccountClickListener) {
//
//        this.calback = calback
//    }

//    override fun getItemViewType(position: Int): Int {
//        val type = when (itemList[position].itemType) {
//            RVItemType.HEADER_ITEM_TYPE -> HEADER_ITEM_TYPE
//            RVItemType.CARD_ITEM_TYPE -> CARD_ITEM_TYPE
//            RVItemType.CASH_ITEM_TYPE -> CASH_ITEM_TYPE
//            RVItemType.TARGET_ITEM_TYPE -> TARGET_ITEM_TYPE
//
//            else -> DEFAULT
//        }
//        return type
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = CategoryItemIncomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false))
        return viewHolder
//
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryItemIncomeViewHolder).bindViews(itemList[position])

//        holder.itemView.setOnClickListener{calback?.onMoneyAccountClickListener(itemList[position])}
//        holder.itemView.setOnLongClickListener{calback?.onMoneyAccountLongClickListener(itemList[position])}
    }




}