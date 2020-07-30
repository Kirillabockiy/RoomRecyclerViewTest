package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.Helper.IDTypeMoneyAccount
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_add_cash_money_account.*
import java.util.*


class AddCashMoneyAccountFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null
    private val EDIT_TEXT_IS_EMPTY: String = "EDIT_TEXT_IS_EMPTY"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_cash_money_account, container, false)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_save_cash_account.setOnClickListener(View.OnClickListener {

            if(edtxt_title_cash_account.text.toString() == "") {
                edtxt_title_cash_account.setError("Введите название счета")
            }

            if(edtxt_balance_cash_account.text.toString() == "") {

                edtxt_balance_cash_account.setError("Введите баланс")
            }

            if(edtxt_title_cash_account.text.toString() != "" && edtxt_balance_cash_account.text.toString() != "") {
                mainActivityViewModel?.insertMoneyAccount(
                    MoneyAccount(
                        id = UUID.randomUUID().toString(),
                        accountType = IDTypeMoneyAccount.TYPE_CASH_MONEY_ACCOUNT,
                        title = edtxt_title_cash_account.text.toString(),
                        bank_name = "",
                        card_number = "",
                        currency = spinner_cash_money_account_currency.selectedItem.toString(),
                        current_balance = edtxt_balance_cash_account.text.toString(),
                        target_balance = "",
                        is_overal_balance = if(is_overal_balance_cash_account.isChecked) true else false


                    ))

                clearFields()
                findNavController().navigateUp()



        }




        })



    }

    fun checkCorrectInputData() : Boolean {

        var correct : Boolean = false


        return correct
    }

    private fun clearFields() {
        edtxt_title_cash_account.setText("")
        edtxt_balance_cash_account.setText("")
    }

    private fun generateUUID(): String {

        return UUID.randomUUID().toString()

    }

}
