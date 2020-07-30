package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel


class AboutMoneyAccountFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null
    private var ID_ITEM: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view = inflater.inflate(R.layout.fragment_about_money_account, container, false)






        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        if(ID_ITEM != null) {
//            id_item.text = "ID_ITEM= " + ID_ITEM.toString()
//
//            btn_load.setOnClickListener(View.OnClickListener {
//                val model = moneyAccountViewModel?.loadmoneyAccountbyId(arguments?.get("id") as Int)
//                setData(model)
//
//            })
//
//        }


        super.onViewCreated(view, savedInstanceState)
    }



//    fun setData(model: MoneyAccount?) {
//
//        if (model != null) {
//            txt_money_account_name.text = model.name
//            txt_money_account_type.text = model.accountType
//            txt_money_account_balance.text = model.currentBalance
//        }
//
//    }


}
