package com.kirillabockiy.examplemvvmapp.Model

import androidx.recyclerview.widget.RecyclerView


abstract class RVOperationItemType(
    val itemType: String
) {


    companion object {
        const val HEADER_ITEM_TYPE = "HEADER_ITEM_TYPE"
        const val INCOME_ITEM_TYPE = "INCOME_ITEM_TYPE"
        const val CONSUMPTION_ITEM_TYPE = "CONSUMPTION_ITEM_TYPE"
        const val TRANSFER_ITEM_TYPE = "TRANSFER_ITEM_TYPE"
    }
}