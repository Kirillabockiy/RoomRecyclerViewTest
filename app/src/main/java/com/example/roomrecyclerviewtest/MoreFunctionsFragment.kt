package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_more_functions.*

/**
 * A simple [Fragment] subclass.
 */
class MoreFunctionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_more_functions, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_more_banks.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_moreFunctionsFragment_to_addBankFragment)
        })

        btn_more_category_income.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_global_addIncomeConsumptionCategoryFragment)
        })

        btn_more_category_consumption.setOnClickListener(View.OnClickListener {

            findNavController().navigate(R.id.action_global_consumptionCategoryFragment)
        })
    }
}
