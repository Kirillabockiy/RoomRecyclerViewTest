package com.example.roomrecyclerviewtest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.roomrecyclerviewtest.Models.MoneyAccount
import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_about_money_account.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentAboutMoneyAccount : Fragment() {
    private var moneyAccountViewModel: MoneyAccountViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view = inflater.inflate(R.layout.fragment_about_money_account, container, false)


        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        btn_load.setOnClickListener(View.OnClickListener {
            setData(moneyAccountViewModel?.loadmoneyAccountbyId(arguments?.get("id") as Int))

        })



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
