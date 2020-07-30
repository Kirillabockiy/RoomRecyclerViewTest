package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels


import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.MultipleTypesAdapter
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountListViewModel
import com.kirillabockiy.examplemvvmapp.Model.CardItem
import com.kirillabockiy.examplemvvmapp.Model.CashItem
import com.kirillabockiy.examplemvvmapp.Model.MoneyAccountListForRV
import kotlinx.android.synthetic.main.fragment_accounts_main.*
import kotlin.collections.ArrayList


class AccountsMainFragment : Fragment() {

    lateinit var adapter: MultipleTypesAdapter

    val moneyAccountListViewModel  by viewModels<MoneyAccountListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_accounts_main, container, false)


        moneyAccountListViewModel.moneyAccountListForRV?.observe(viewLifecycleOwner, Observer {this.setMoneyAccountListToRV(it)})
//        moneyAccountListViewModel.viewState.observe(viewLifecycleOwner, Observer { renderViewState(it) })
        return view


    }

//    private fun renderViewState(viewState: MoneyAccountListViewModel.ViewState?) {
//
//
//        viewState?.let {
//            when(it.isLoading) {
//
//                true -> loadingStarted()
//                false -> loadingFinished()
//
//            }
//
//        }
//
//
//    }
//
//    private fun loadingFinished() {
//        money_account_list_loading_progress_bar.visibility = View.GONE
//
//    }
//
//    private fun loadingStarted() {
//        money_account_list_loading_progress_bar.visibility = View.GONE
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_add_money_account.setOnClickListener{
            findNavController().navigate(R.id.action_accountsMainFragment_to_addMoneyAccountBottomSheetFragment)
        }

    }

    private fun setMoneyAccountListToRV(arrayList: ArrayList<MoneyAccountListForRV>?) {

        arrayList?.let {

            if (it.isEmpty()) {
                recycler_view.visibility = View.GONE
                txt_no_money_account_item.visibility = View.VISIBLE

            } else {
                recycler_view.visibility = View.VISIBLE
                txt_no_money_account_item.visibility = View.GONE
                adapter = MultipleTypesAdapter(requireContext(), it)
                adapter.attachCalback(object : OnMoneyAccountClickListener {

                    override fun onMoneyAccountClickListener(moneyAccountListForRV: MoneyAccountListForRV) {
                        //                    openAboutMoneyAccountFragment()
                        Log.i("ITEM_TYPE", moneyAccountListForRV.itemType)
                        if (moneyAccountListForRV.itemType == MoneyAccountListForRV.CASH_ITEM_TYPE) {

                            moneyAccountListViewModel?.deleteMoneyAccountById((moneyAccountListForRV as CashItem).id)
                        }

                        if (moneyAccountListForRV.itemType == MoneyAccountListForRV.CARD_ITEM_TYPE) {

                            moneyAccountListViewModel?.deleteMoneyAccountById((moneyAccountListForRV as CardItem).id)
                        }


                    }

                })
                val layoutManager = LinearLayoutManager(requireContext())
                recycler_view.layoutManager = layoutManager
                recycler_view.adapter = adapter
            }
        } ?: run {

            Log.i("ERROR", "LIST_IS_NULL")
        }

    }




//    fun openAboutMoneyAccountFragment() {
//
//        findNavController().navigate(R.id.action_accountsMainFragment_to_cardAboutFragment)
//    }
}
