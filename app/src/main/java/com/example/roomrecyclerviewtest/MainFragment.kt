//package com.example.roomrecyclerviewtest.Fragments
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.roomrecyclerviewtest.Adapters.MoneyAccountAdapter
//import com.example.roomrecyclerviewtest.Interfaces.OnMoneyAccountClickListener
//import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
//
//import com.example.roomrecyclerviewtest.R
//import com.example.roomrecyclerviewtest.ViewModels.MoneyAccountViewModel
//import kotlinx.android.synthetic.main.fragment_accounts_main.*
//
///**
// * A simple [Fragment] subclass.
// */
//class MainFragment : Fragment() {
//
//    lateinit var adapter: MoneyAccountAdapter
//    private var moneyAccountViewModel: MoneyAccountViewModel? = null
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_accounts_main, container, false)
//        moneyAccountViewModel = ViewModelProviders.of(this).get(MoneyAccountViewModel::class.java)
////
//        moneyAccountViewModel?.getMoneyAccounts()?.observe(viewLifecycleOwner, Observer<List<MoneyAccount>> { this.renderMoneyAccountslist(it) })
//
//
//        return view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        fab.setOnClickListener(View.OnClickListener {
////
////        view.findNavController().navigate(R.id.action_mainFragment_to_fragmentAddMoneyAccount)
////
////        })
//
//    }
//
//    private fun renderMoneyAccountslist(moneyAccounts: List<MoneyAccount>){
//
//        adapter = MoneyAccountAdapter(context!!, moneyAccounts)
//        adapter.attachCalback(object : OnMoneyAccountClickListener {
//            override fun onMoneyAccountClickListener(moneyAccount: MoneyAccount) {
//                openAboutMoneyAccountFragment(moneyAccount.id)
//            }
//
//
//        })
//        val layoutManager = LinearLayoutManager(context!!)
////        layoutManager.stackFromEnd = true
//        recyclerView.layoutManager = layoutManager
////        layoutManager.scrollToPosition(0)
//        recyclerView.adapter = adapter
//
////
//    }
//
//    fun openAboutMoneyAccountFragment(id: Int) {
//
////        var bundle = bundleOf("id" to id)
////        view?.findNavController()
////            ?.navigate(R.id.action_mainFragment_to_fragmentAboutMoneyAccount, bundle )
//    }
//
//}
