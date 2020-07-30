package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.roomrecyclerviewtest.DataBase.Entity.Bank
import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_add_card_money_account.*
import java.util.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomrecyclerviewtest.Helper.IDTypeMoneyAccount


class AddCardMoneyAccountFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null

    var list_of_items = arrayOf("Item 1", "Item 2", "Item 3")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_card_money_account, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        mainActivityViewModel?.getBankList()?.observe(viewLifecycleOwner, Observer {
            this.loadBankList(it)


        })


        btn_save_card_account.setOnClickListener(View.OnClickListener {


//            moneyAccountViewModel?.insertBank(Bank(UUID.randomUUID().toString()))

//


            if(edtxt_title_card_account.text.toString() == "") {
                edtxt_title_card_account.setError("Введите название счета")
            }

            if(edtxt_balance_card_account.text.toString() == "") {

                edtxt_balance_card_account.setError("Введите баланс")
            }
//
            if(edtxt_title_card_account.text.toString() != "" && edtxt_balance_card_account.text.toString() != "") {
//
                mainActivityViewModel?.insertMoneyAccount(
                    MoneyAccount(
                        id = UUID.randomUUID().toString(),
                        accountType = IDTypeMoneyAccount.TYPE_CARD_MONEY_ACCOUNT,
                        title = edtxt_title_card_account.text.toString(),
                        bank_name = spinner_bank_name_card_account.selectedItem.toString(),
                        card_number = if(edtxt_card_number_card_account.text.toString() != "") "****" + edtxt_card_number_card_account.text.toString() else "",
                        currency = spinner_currency_card_account.selectedItem.toString(),
                        current_balance = edtxt_balance_card_account.text.toString(),
                        target_balance = "",
                        is_overal_balance = if(is_overal_balance_cash_account.isChecked) true else false


                )
                )

                findNavController().navigateUp()
            }


        })
    }

    private fun loadBankList(bankList: List<Bank>) {

        val adapter = ArrayAdapter<String>(
            context!!,
            android.R.layout.simple_spinner_item
        )

        if (!bankList.isEmpty()) {

            bankList.forEach {
                adapter.add(it.bank_name)
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner_bank_name_card_account.adapter = adapter


        Log.i("BANK_LIST", bankList.size.toString())
    }

}
//        if (!bankList.isEmpty()) {
//            Log.i("BANK_LIST", bankList[0].bank_name)
//
//    } else Log.i("BANK_LIST", "Пусто")
//
//
//    }





