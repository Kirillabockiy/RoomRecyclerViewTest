package com.kirillabockiy.examplemvvmapp.Model

import androidx.recyclerview.widget.RecyclerView


abstract class MoneyAccountListForRV(
    val itemType: String
) {


    companion object {
        const val CARD_ITEM_TYPE = "CARD_ITEM_TYPE"
        const val CASH_ITEM_TYPE = "CASH_ITEM_TYPE"
        const val HEADER_ITEM_TYPE = "HEADER_ITEM_TYPE"
        const val TARGET_ITEM_TYPE = "TARGET_ITEM_TYPE"
        const val BANK_ITEM_TYPE = "BANK_ITEM_TYPE"
    }
}