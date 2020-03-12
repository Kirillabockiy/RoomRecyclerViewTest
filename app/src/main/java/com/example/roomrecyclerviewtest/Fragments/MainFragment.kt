package com.example.roomrecyclerviewtest.Fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.MoneyAccountAdapter
import com.example.roomrecyclerviewtest.Models.MoneyAccount

import com.example.roomrecyclerviewtest.R
import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var adapter: MoneyAccountAdapter
    private var moneyAccountViewModel: MoneyAccountViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)
//
        moneyAccountViewModel?.getMoneyAccounts()?.observe(viewLifecycleOwner, Observer<List<MoneyAccount>> { this.renderMoneyAccountslist(it) })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_main_account_fab.setOnClickListener(View.OnClickListener {

        view.findNavController().navigate(R.id.action_mainFragment_to_fragmentAddMoneyAccount)

        })

    }

    private fun renderMoneyAccountslist(moneyAccounts: List<MoneyAccount>?){

        adapter = MoneyAccountAdapter(context!!, moneyAccounts)
        val layoutManager = LinearLayoutManager(context!!)
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

//
    }
}
