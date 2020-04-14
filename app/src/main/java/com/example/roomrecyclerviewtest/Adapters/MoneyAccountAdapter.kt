package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
//import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.R

//class MoneyAccountAdapter (private val context: Context, private val moneyAccounts: List<MoneyAccount>) : RecyclerView.Adapter<MoneyAccountAdapter.ViewHolder>(){
//
//
//
//    private var calback: OnMoneyAccountClickListener? = null
//
//    fun attachCalback(calback: OnMoneyAccountClickListener) {
//
//        this.calback = calback
//    }
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
//        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.money_account_item, viewGroup, false)
//
//
//
//
//
//        return ViewHolder(rootView)
//    }
//
//    override fun getItemCount(): Int {
//        return moneyAccounts.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
//
//    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
////        viewHolder.itemView.animation = AnimationUtils.loadAnimation(context,R.anim.item_animation_fall_down)
//        viewHolder.bind(moneyAccounts[index])
//
//
//
//
//
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//    {
//
//
//        fun bind(item: MoneyAccount) {
//
//            itemView.setOnClickListener{
//                calback?.onMoneyAccountClickListener(item)
//            }
//
//            moneyAccountName.text = item.name
//            moneyAccountType.text = item.accountType
//            moneyAccountBalance.text = item.currentBalance
////
//        }
//
//        var moneyAccountName: TextView = itemView.findViewById(R.id.account_name_text_view) as TextView
//        var moneyAccountType: TextView = itemView.findViewById(R.id.account_type_text_view) as TextView
//        var moneyAccountBalance: TextView = itemView.findViewById(R.id.account_balance_text_view) as TextView
//
//
//
//    }
//
//}