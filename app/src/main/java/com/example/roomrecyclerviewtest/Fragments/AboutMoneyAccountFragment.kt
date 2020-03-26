package com.example.roomrecyclerviewtest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_about_money_account.*


class AboutMoneyAccountFragment : Fragment() {

    private var moneyAccountViewModel: MoneyAccountViewModel? = null
    private var ID_ITEM: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view = inflater.inflate(R.layout.fragment_about_money_account, container, false)


        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)
        ID_ITEM = arguments?.get("id") as Int
        moneyAccountViewModel?.loadmoneyAccountbyId(arguments?.get("id") as Int)?.observe(viewLifecycleOwner, Observer<MoneyAccount> { setData(it) })



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



    fun setData(model: MoneyAccount?) {

        if (model != null) {
            txt_money_account_name.text = model.name
            txt_money_account_type.text = model.accountType
            txt_money_account_balance.text = model.currentBalance
        }

    }


}
