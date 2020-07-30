package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.HorizontalMoneyAccountRVAdapter
import com.example.roomrecyclerviewtest.DataBase.Entity.Operation
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountHorizontalRVClickListener
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import com.example.roomrecyclerviewtest.ViewModels.OperationFragmentViewModel
import com.kirillabockiy.examplemvvmapp.Model.RVOperationItemType
import kotlinx.android.synthetic.main.fragment_add_consumption_operation.*
import kotlinx.android.synthetic.main.fragment_add_operation_income.*
import java.util.*


class AddOperationConsumptionFragment : Fragment() {

    lateinit var adapter: HorizontalMoneyAccountRVAdapter
    private var mainActivityViewModel: MainActivityViewModel? = null
    private var operationFragmentViewModel: OperationFragmentViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_consumption_operation, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        txt_add_consumption_category.setOnClickListener(View.OnClickListener {
//
//            findNavController().navigate(R.id.action_global_consumptionCategoryFragment)
//
//        })

        textView20.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_addConsumptionOperationFragment_to_selectCategoryConsumptionOperationDialogFragment)
        })

        btn_select_cons_category.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_addConsumptionOperationFragment_to_selectCategoryConsumptionOperationDialogFragment)

        })


        btn_save_operation_consumption.setOnClickListener(View.OnClickListener {


            if (mainActivityViewModel?.currentMoneyAccount == null) {

                Log.i("ERROR", "Выберете счет!")
            } else {

                if(operationFragmentViewModel?.currentConsumptioncategory?.value == null) {
                    Log.i("ERROR", "Выберете категорию расхода!")

                } else {

                    if(txt_sum_operation_consumption.text.toString() == "") {
                        txt_sum_operation_consumption.error = "Введите сумму операции"

                    } else {
                        val acc = mainActivityViewModel?.currentMoneyAccount
                        val currentBalance = Integer.parseInt(acc!!.current_balance)
                        if(currentBalance < Integer.parseInt(txt_sum_operation_consumption.text.toString() )) {
                            txt_sum_operation_consumption.error = "Суммы на выбранном счете не достаточно для выполнения операции"

                        } else {

                            acc.current_balance = (currentBalance - Integer.parseInt(txt_sum_operation_consumption.text.toString())).toString()


                            mainActivityViewModel?.insertOperationAndUpdateMoneyAccount(
                                Operation(
                                    id = UUID.randomUUID().toString(),
                                    operation_type = RVOperationItemType.CONSUMPTION_ITEM_TYPE,
                                    income_category =  "",
                                    consumption_category = operationFragmentViewModel?.currentConsumptioncategory!!.value!!.consumption_title,
                                    to_account_id = "",
                                    to_account_title = "",
                                    from_account_id = acc.id,
                                    from_account_title = acc.title,
                                    summ = Integer.parseInt(txt_sum_operation_consumption.text.toString().trim()),
                                    date_time = System.currentTimeMillis()
                                ), acc
                            )



                            findNavController().navigateUp()
                        }

                    }



                }
            }





        })

        mainActivityViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        operationFragmentViewModel = activity?.let {
            ViewModelProvider(it).get(OperationFragmentViewModel::class.java)

        }

//        operationFragmentViewModel?.setDefaultConsumptionCategory()

//
//        mainActivityViewModel?.getAllConsumptionCategory()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadConsumptionCategoryListToSpinner(it) })
        mainActivityViewModel?.getMoneyAccountList()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadMoneyAccountListToHorizontalRV(it) })

        operationFragmentViewModel?.getCurrentConsumptionCategory()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            textView20.text = it.consumption_title
        })

//
//
//
//        txt_left.setOnClickListener(View.OnClickListener {
//
//            findNavController().navigate(R.id.action_global_consumptionCategoryFragment)
//        })
//
//        txt_right.setOnClickListener(View.OnClickListener {
//
//            findNavController().navigate(R.id.action_global_addMoneyAccountBottomSheetFragment)
//        })
//
//
//        btn_save_operation_consumption.setOnClickListener(View.OnClickListener {
////
////            mainActivityViewModel?.insertOperationAndUpdateMoneyAccount(
////                Operation(
////                    UUID.randomUUID().toString(),
////                    RVOperationItemType.CONSUMPTION_ITEM_TYPE,
////                    "",
////                    left_spinner_consumption_category.selectedItem.toString(),
////                    "",
////                    right_spinner_from_account.selectedItem.toString(),
////                    Integer.parseInt(txt_sum_operation_income.text.toString().trim()),
////                    System.currentTimeMillis()
////                )
////            )
//            findNavController().navigateUp()
//        })
//
//    }
//
//
//
////            else {
////
//////                recycler_view.visibility = View.GONE
//////                txt_no_money_account_item.visibility = View.VISIBLE
////
////            }
//
//
//
//
//
//
//
//
//    private fun loadConsumptionCategoryListToSpinner(consumptionCategory: List<ConsumptionCategory>) {
//
////        Log.i("INCOME_CATEGORY_SIZE", consumptionCategory.size.toString())
//
//        val adapter = ArrayAdapter<String>(
//            context!!,
//            android.R.layout.simple_spinner_item
//        )
//
//        if (!consumptionCategory.isEmpty()) {
//
//            consumptionCategory.forEach {
//                adapter.add(it.consumption_title)
//            }
//        }
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//        left_spinner_consumption_category.adapter = adapter
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
//        right_spinner_from_account.adapter = adapter
//
//
    }

    private fun loadMoneyAccountListToHorizontalRV(it: List<MoneyAccountMin>?) {


        if (it != null) {
            adapter = HorizontalMoneyAccountRVAdapter(context!!, it)
            adapter.attachCalback(object : OnMoneyAccountHorizontalRVClickListener {
                override fun onMoneyAccountHorizontalRVClick(item: MoneyAccountMin) {


                    textView17.text = item.title
                    textView18.text = item.current_balance + " ₽"
                    mainActivityViewModel?.getMoneyAccountById(item.id)
                }


            })
            val layoutManager = LinearLayoutManager(context!!)
            recycler_view_horizontal_money_account.layoutManager = layoutManager
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recycler_view_horizontal_money_account.adapter = adapter


        }



    }

    override fun onDestroy() {
        super.onDestroy()


    }
}
