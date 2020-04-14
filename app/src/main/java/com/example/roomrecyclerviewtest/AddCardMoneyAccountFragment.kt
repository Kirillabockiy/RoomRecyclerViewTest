package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.roomrecyclerviewtest.Models.CardMoneyAccount
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_add_card_money_account.*
import java.util.*


class AddCardMoneyAccountFragment : Fragment() {

    private var moneyAccountViewModel: MoneyAccountViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_card_money_account, container, false)

        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_save_card_account.setOnClickListener(View.OnClickListener {

            if(edtxt_title_card_account.text.toString() == "") {
                edtxt_title_card_account.setError("Введите название счета")
            }

            if(edtxt_balance_card_account.text.toString() == "") {

                edtxt_balance_card_account.setError("Введите баланс")
            }

            if(edtxt_title_card_account.text.toString() != "" && edtxt_balance_card_account.text.toString() != "") {

                moneyAccountViewModel?.insertCardMoneyAccount(CardMoneyAccount(
                    id = generateUUID(),
                    title = edtxt_title_card_account.text.toString(),
                    bankName = if(edtxt_bank_name_card_account.text.toString() != "") edtxt_bank_name_card_account.text.toString() else "",
                    cardNumber = if(edtxt_card_number_card_account.text.toString() != "") "****" + edtxt_card_number_card_account.text.toString() else "",
                    balance = edtxt_balance_card_account.text.toString()


                ))

                findNavController().navigateUp()
            }


        })
    }

    private fun generateUUID(): String {

        return UUID.randomUUID().toString()

    }
}
