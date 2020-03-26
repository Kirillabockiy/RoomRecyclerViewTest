package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_overview_all.*

/**
 * A simple [Fragment] subclass.
 */
class OverviewAllFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview_all, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_money_accounts.setOnClickListener(View.OnClickListener {

            view.findNavController().navigate(R.id.action_overviewAllFragment_to_mainFragment)
        })

    }
}
