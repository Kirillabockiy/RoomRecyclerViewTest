package com.example.roomrecyclerviewtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_money_account_bottom_sheet.*


class AddMoneyAccountBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_money_account_bottom_sheet, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        card_cash.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_addMoneyAccountBottomSheetFragment_to_addCashAccountFragment)
        })

        card_card.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_addMoneyAccountBottomSheetFragment_to_addCardMoneyAccountFragment)
        })
    }
}
