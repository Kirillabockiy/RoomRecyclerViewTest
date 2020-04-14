package com.kirillabockiy.examplemvvmapp.Model

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrecyclerviewtest.Interfaces.ItemViewHolder
import com.example.roomrecyclerviewtest.R



data class TargetItem(
    var title: String,
    var currentAmount: String,
    var targetAmount: String,
    var progress: Int

): RVItemType(RVItemType.TARGET_ITEM_TYPE)

class TargetItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemViewHolder {


    val txtTitle = itemView.findViewById<TextView>(R.id.txt_target_title)
    val txtCurrentAmount = itemView.findViewById<TextView>(R.id.txt_current_amount)
    val txtTargetAmount = itemView.findViewById<TextView>(R.id.txt_target_amount)
    val progress = itemView.findViewById<ProgressBar>(R.id.progress_bar)


    override fun bindViews(rvItemType: RVItemType) {
        val mItem = rvItemType as TargetItem


        txtTitle.text = mItem.title
        txtCurrentAmount.text = mItem.currentAmount
        txtTargetAmount.text = mItem.targetAmount
        progress.progress = mItem.progress




//        txtTitle.text = "mItem.title"
//        txtBankName.text = "mItem.bankName"
//        txtCardNumber.text = "mItem.cardNumber"
//        txtBalance.text = "mItem.balance"


    }


}