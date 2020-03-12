package com.example.roomrecyclerviewtest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.roomrecyclerviewtest.Models.MoneyAccount

import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_add_money_account.*


class FragmentAddMoneyAccount : Fragment() {

    private var moneyAccountViewModel: MoneyAccountViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_add_money_account, container, false)

        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var acc_name: String?
        var acc_type: String?
        var acc_balance: String?


        btn_create_money_account.setOnClickListener(View.OnClickListener {
            val moneyAccount = MoneyAccount(
                0,
                edt_money_account_name.text.toString(),
                edt_money_account_type.text.toString(),
                edt_money_account_balance.text.toString())

            moneyAccountViewModel?.setMoneyAccount(moneyAccount)

            view.findNavController().navigate(R.id.action_fragmentAddMoneyAccount_to_mainFragment)
        })







    }
}
