package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_transaction_bottom_sheet.*


class AddTransactionBottomSheetFragment: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_transaction_bottom_sheet, container, false)



        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        card_consumption.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_addTransactionBottomSheetFragment_to_addConsumptionOperationFragment)
        })

        card_transfer.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_addTransactionBottomSheetFragment_to_addOperationTransferFragment)
        })

        card_income.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_addTransactionBottomSheetFragment_to_addOperationIncomeFragment)
        })
    }
}
