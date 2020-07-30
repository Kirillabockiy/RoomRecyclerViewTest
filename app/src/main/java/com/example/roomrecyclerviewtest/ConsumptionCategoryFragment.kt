package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.CategoryItemListAdapter
import com.example.roomrecyclerviewtest.Adapters.ConsumptionCategoryItemListAdapter
import com.example.roomrecyclerviewtest.DataBase.Entity.ConsumptionCategory
import com.example.roomrecyclerviewtest.DataBase.Entity.IncomeCategory
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_add_income_consumption_category.*
import kotlinx.android.synthetic.main.fragment_consumption_category.*


class ConsumptionCategoryFragment : Fragment() {

    lateinit var adapter: ConsumptionCategoryItemListAdapter
    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_consumption_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel?.getAllConsumptionCategory()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadConsumptionCategoryListToRv(it) })


        btn_add_consumption_category.setOnClickListener(View.OnClickListener {


            if (edtxt_category_consumption.text.toString() != "") {
                mainActivityViewModel?.insertConsumptionCategory(
                    ConsumptionCategory(
                        edtxt_category_consumption.text.toString()))
                edtxt_category_consumption.setText("")

            }

            else edtxt_category_consumption.setError("Введите название категории")


        })



    }


    fun loadConsumptionCategoryListToRv(list: List<ConsumptionCategory>) {

        if(!list.isEmpty()) {
//            recycler_view.visibility = View.VISIBLE
//            txt_no_money_account_item.visibility = View.GONE

//            moneyAccountList.forEach{
//
//                if (it.accountType == RVItemType.CARD_ITEM_TYPE)
//                    rvItemList.add(CardItem(it.id, it.title, it.bank_name, it.card_number, it.current_balance))
//                if (it.accountType == RVItemType.CASH_ITEM_TYPE)
//                    rvItemList.add(CashItem(it.id, it.title, it.current_balance))
//
//            }

            adapter = ConsumptionCategoryItemListAdapter(context!!,  list)
//            adapter.attachCalback(object : OnMoneyAccountClickListener {
//
//
//                override fun onMoneyAccountClickListener(rvItemType: RVItemType) {
//                    openAboutMoneyAccountFragment()
//
////                    if(rvItemType.itemType == RVItemType.CASH_ITEM_TYPE) {
////
////                        moneyAccountViewModel?.deleteCashMoneyAccount((rvItemType as CashItem).id)
////                    }
////
////                    if(rvItemType.itemType == RVItemType.CARD_ITEM_TYPE) {
////
////                        moneyAccountViewModel?.deleteCardMoneyAccount((rvItemType as CardItem).id)
////                    }
//
//                }
//
//
//            })
            val layoutManager = LinearLayoutManager(context!!)
            rv_category_consumption_list.layoutManager = layoutManager
            rv_category_consumption_list.adapter = adapter

        }

        else {

//            recycler_view.visibility = View.GONE
//            txt_no_money_account_item.visibility = View.VISIBLE

        }

    }

}
