package com.example.roomrecyclerviewtest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.R

class MoneyAccountAdapter (private val context: Context, private val moneyAccounts: List<MoneyAccount>?) : RecyclerView.Adapter<MoneyAccountAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.money_account_item, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return moneyAccounts?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
//        viewHolder.itemView.animation = AnimationUtils.loadAnimation(context,R.anim.item_animation_fall_down)
        viewHolder.moneyAccountName.text = moneyAccounts?.get(index)?.name
        viewHolder.moneyAccountType.text = moneyAccounts?.get(index)?.accountType
        viewHolder.moneyAccountBalance.text = moneyAccounts?.get(index)?.currentBalance
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var moneyAccountName: TextView = itemView.findViewById(R.id.account_name_text_view) as TextView
        var moneyAccountType: TextView = itemView.findViewById(R.id.account_type_text_view) as TextView
        var moneyAccountBalance: TextView = itemView.findViewById(R.id.account_balance_text_view) as TextView
    }

}