package com.example.roomrecyclerviewtest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.roomrecyclerviewtest.Adapters.MultipleTypesAdapter
import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount
import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import com.kirillabockiy.examplemvvmapp.Model.*
import kotlinx.android.synthetic.main.fragment_accounts_main.*


class AccountsMainFragment : Fragment() {

    lateinit var adapter: MultipleTypesAdapter
    private var moneyAccountViewModel: MoneyAccountViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_accounts_main, container, false)
        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)


        moneyAccountViewModel?.getData()?.observe(viewLifecycleOwner, Observer { this.renderMoneyAccountslist(it) })

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_add_money_account.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_accountsMainFragment_to_addMoneyAccountBottomSheetFragment)
        })

    }

    private fun renderMoneyAccountslist(list: ArrayList<RVItemType>){

        if (!list.isEmpty()) {

                recycler_view.visibility = View.VISIBLE
                txt_no_money_account_item.visibility = View.GONE


            adapter = MultipleTypesAdapter(context!!,  list)
            adapter.attachCalback(object : OnMoneyAccountClickListener {


                override fun onMoneyAccountClickListener(rvItemType: RVItemType) {
//                openAboutMoneyAccountFragment()

                    if(rvItemType.itemType == RVItemType.CASH_ITEM_TYPE) {

                        moneyAccountViewModel?.deleteCashMoneyAccount((rvItemType as CashItem).id)
                    }

                    if(rvItemType.itemType == RVItemType.CARD_ITEM_TYPE) {

                        moneyAccountViewModel?.deleteCardMoneyAccount((rvItemType as CardItem).id)
                    }

                }


            })
            val layoutManager = LinearLayoutManager(context!!)
            recycler_view.layoutManager = layoutManager
            recycler_view.adapter = adapter


        } else {

            recycler_view.visibility = View.GONE
            txt_no_money_account_item.visibility = View.VISIBLE

        }


//
    }


    fun openAboutMoneyAccountFragment() {

        findNavController().navigate(R.id.action_accountsMainFragment_to_cardAboutFragment)
    }
}
