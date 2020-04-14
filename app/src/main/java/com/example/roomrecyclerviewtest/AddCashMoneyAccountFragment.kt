package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount
import com.example.roomrecyclerviewtest.Ultils.Utils
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_add_cash_money_account.*
import java.util.*


class AddCashMoneyAccountFragment : Fragment() {

    private var moneyAccountViewModel: MoneyAccountViewModel? = null
    private val EDIT_TEXT_IS_EMPTY: String = "EDIT_TEXT_IS_EMPTY"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_cash_money_account, container, false)
        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)

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
                moneyAccountViewModel?.insertCashMoneyAccount(CashMoneyAccount(
                    id = generateUUID(),
                    title = edtxt_title_cash_account.text.toString(),
                    balance = edtxt_balance_cash_account.text.toString()))


//                clearFindViewByIdCache()
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
