package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.roomrecyclerviewtest.DataBase.Entity.Bank
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_bank.*


class AddBankFragment :  BottomSheetDialogFragment() {

        private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_bank, container, false)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_bank.setOnClickListener(View.OnClickListener {



            mainActivityViewModel?.insertBank(Bank(edtxt_bank_name.text.toString()))
        })


    }

}
