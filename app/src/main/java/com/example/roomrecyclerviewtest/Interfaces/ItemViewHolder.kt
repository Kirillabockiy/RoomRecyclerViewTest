package com.example.roomrecyclerviewtest.Interfaces

import com.kirillabockiy.examplemvvmapp.Model.RVItemType

interface ItemViewHolder {
    fun bindViews(rvItemType: RVItemType)

}