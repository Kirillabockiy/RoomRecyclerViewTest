package com.example.roomrecyclerviewtest


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.DataBase.Entity.Operation
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import com.kirillabockiy.examplemvvmapp.Model.RVOperationItemType
import kotlinx.android.synthetic.main.fragment_add_operation_income.*
import java.util.*


class AddOperationIncomeFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null

    private var idMoneyAccount: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_operation_income, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        mainActivityViewModel?.getAllIncomeCategory()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadIncomeCategoryListToSpinner(it) })
//        mainActivityViewModel?.getMoneyAccountList()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadMoneyAccountListToSpinner(it) })
//
//        mainActivityViewModel?.viewState?.observe(viewLifecycleOwner, Observer { this.renderUI(it) })


//        mainActivityViewModel?.insertOperationAndUpdateMoneyAccount(
//                Operation(
//                    id = UUID.randomUUID().toString(),
//                    operation_type = RVOperationItemType.INCOME_ITEM_TYPE,
//                    income_category = "Аванс",
//                    consumption_category = "",
//                    from_account_title = "",
//                    to_account_title = "Тинькофф",
//                    to_account_id = "36a6d12e-eff5-4cd2-a3a3-ce33866da9c8",
//                    from_account_id = "",
//                    summ = 10000,
//                    date_time = System.currentTimeMillis()
//                ), MoneyAccount("36a6d12e-eff5-4cd2-a3a3-ce33866da9c8",
//                0,
//                "Основная карта",
//            "Тинькофф", "****5799",
//                "Российский рубль - ₽",
//                "10125",
//                "",
//                true
//            )
//        )


//        txt_left.setOnClickListener(View.OnClickListener {
//
//            findNavController().navigate(R.id.action_global_addIncomeConsumptionCategoryFragment)
//        })
//
//        txt_right.setOnClickListener(View.OnClickListener {
//
//            findNavController().navigate(R.id.action_global_addMoneyAccountBottomSheetFragment)
//        })


        btn_save_operation_income.setOnClickListener(View.OnClickListener {



//            if (idMoneyAccount != null) {
//
//                Log.i("ID_MONEY_ACCOUNT", idMoneyAccount)
//
//            } else {
//
//                Log.i("ID_MONEY_ACCOUNT", "ID = null")
//            }
//
//
//            val acc = mainActivityViewModel?.currentMoneyAccount
//            val currentBalance = Integer.parseInt(acc!!.current_balance)
//            acc.current_balance = (currentBalance + Integer.parseInt(txt_sum_operation_income.text.toString())).toString()
//
//
//            mainActivityViewModel?.insertOperationAndUpdateMoneyAccount(
//                Operation(
//                    id = UUID.randomUUID().toString(),
//                    operation_type = RVOperationItemType.INCOME_ITEM_TYPE,
//                    income_category = left_spinner_income_category.selectedItem.toString(),
//                    consumption_category = "",
//                    to_account_id =
//                    right_spinner_to_account.selectedItem.toString(),
//                    "",
//                    Integer.parseInt(txt_sum_operation_income.text.toString().trim()),
//                    System.currentTimeMillis()
//                ), acc)
//            findNavController().navigateUp()
        })

    }

//    private fun renderUI(it: MainActivityViewModel.ViewState?) {
//
//        when(it?.isLoading) {
//            true -> {progressBar2.visibility = View.VISIBLE
//
//            }
//            false -> {progressBar2.visibility = View.GONE
//                if(mainActivityViewModel?.currentMoneyAccount != null) {
//
//
//
//
//                    textInputLayout5.hint = "Сумма, Р / " + mainActivityViewModel?.currentMoneyAccount?.current_balance
//
//                } else {
//                    textInputLayout5.hint = "Сумма, Р"
//
//                }
//
//
//            }
//
//        }
//
//    }


//            else {
//
////                recycler_view.visibility = View.GONE
////                txt_no_money_account_item.visibility = View.VISIBLE
//
//            }








//    private fun loadIncomeCategoryListToSpinner(allIncomeCategory: List<IncomeCategory>) {
//
////        Log.i("INCOME_CATEGORY_SIZE", allIncomeCategory.size.toString())
//
//        val adapter = ArrayAdapter<String>(
//            context!!,
//            android.R.layout.simple_spinner_item
//        )
//
//        if (!allIncomeCategory.isEmpty()) {
//
//            allIncomeCategory.forEach {
//                adapter.add(it.income_title)
//            }
//        }
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//        left_spinner_income_category.adapter = adapter
//
//    }
//
//    private fun loadMoneyAccountListToSpinner(moneyAccountList: List<MoneyAccountMin>){
//
//        Log.i("INCOME_CATEGORY_SIZE", moneyAccountList.size.toString())
//
//        val adapter = ArrayAdapter<String>(
//            context!!,
//            android.R.layout.simple_spinner_item
//        )
//
//        if (!moneyAccountList.isEmpty()) {
//
//            moneyAccountList.forEach {
//                adapter.add(it.title)
//            }
//        }
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//        right_spinner_to_account.adapter = adapter
//        right_spinner_to_account.prompt = "Выберете счет"
//        right_spinner_to_account.setOnItemSelectedListener(object : OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                itemSelected: View, selectedItemPosition: Int, selectedId: Long
//            ) {
//                mainActivityViewModel?.getMoneyAccountById(moneyAccountList[selectedItemPosition].id)
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        })
//
//
//
//
//    }


}
