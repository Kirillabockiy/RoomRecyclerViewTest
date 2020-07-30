package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.OperationItemListAdapter
import com.example.roomrecyclerviewtest.DataBase.Entity.Operation
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import com.kirillabockiy.examplemvvmapp.Model.ConsumptionItem
import com.kirillabockiy.examplemvvmapp.Model.IncomeItem
import com.kirillabockiy.examplemvvmapp.Model.RVOperationItemType
import kotlinx.android.synthetic.main.fragment_add_operation_income.*
import kotlinx.android.synthetic.main.fragment_operations.*


class OperationsFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null

    lateinit var adapter: OperationItemListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_operations, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fab_add_operation.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_operationsFragment_to_addTransactionBottomSheetFragment)
        })


        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel?.getAllOperations()?.observe(viewLifecycleOwner,  androidx.lifecycle.Observer { this.loadAllOperationToRv(it) })




    }



    private fun loadAllOperationToRv(operaionList: List<Operation>) {

        val rvItemList: ArrayList<RVOperationItemType> = ArrayList()


        if(!operaionList.isEmpty()) {
            rv_operation_list.visibility = View.VISIBLE
            txt_no_money_operation_item.visibility = View.GONE

            operaionList.forEach{

                if (it.operation_type == RVOperationItemType.INCOME_ITEM_TYPE)
                    rvItemList.add(
                        IncomeItem(
                            it.id,
                            it.income_category,
                            it.to_account_title,
                            it.summ.toString() + "₽",
                            it.date_time)
                    )

                if (it.operation_type == RVOperationItemType.CONSUMPTION_ITEM_TYPE)
                    rvItemList.add(
                        ConsumptionItem(
                            it.id,
                            it.consumption_category,
                            it.from_account_title,
                            it.summ.toString() + "₽",
                            it.date_time)
                    )


            }


            adapter = OperationItemListAdapter(context!!,  rvItemList)
            val layoutManager = LinearLayoutManager(context!!)


            rv_operation_list.layoutManager = layoutManager
            rv_operation_list.adapter = adapter

        } else {
            rv_operation_list.visibility = View.GONE
            txt_no_money_operation_item.visibility = View.VISIBLE

        }





        }


}
