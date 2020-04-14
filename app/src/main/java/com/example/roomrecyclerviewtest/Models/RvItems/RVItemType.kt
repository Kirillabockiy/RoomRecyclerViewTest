package com.kirillabockiy.examplemvvmapp.Model

import androidx.recyclerview.widget.RecyclerView


abstract class RVItemType(
    val itemType: Int
) {


    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val CARD_ITEM_TYPE = 1
        const val CASH_ITEM_TYPE = 2
        const val TARGET_ITEM_TYPE = 3
    }
}