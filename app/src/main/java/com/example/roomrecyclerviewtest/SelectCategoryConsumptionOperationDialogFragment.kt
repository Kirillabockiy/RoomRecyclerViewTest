package com.example.roomrecyclerviewtest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomrecyclerviewtest.Adapters.ConsumptionCategoryItemListAdapter
import com.example.roomrecyclerviewtest.DataBase.Entity.ConsumptionCategory
import com.example.roomrecyclerviewtest.Interfaces.OnConsumptionCategoryClickListener
import com.example.roomrecyclerviewtest.ViewModels.OperationFragmentViewModel
import kotlinx.android.synthetic.main.fragment_consumption_category.*
import kotlinx.android.synthetic.main.fragment_select_category_consumption_operation_dialog.*


class SelectCategoryConsumptionOperationDialogFragment : DialogFragment() {


    private var operationFragmentViewModel: OperationFragmentViewModel? = null
    lateinit var adapter: ConsumptionCategoryItemListAdapter
    override fun onStart() {
        super.onStart()

        val d: Dialog? = dialog
        if (d != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT;
            val height = ViewGroup.LayoutParams.MATCH_PARENT;
            d.window?.setLayout(width, height)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_select_category_consumption_operation_dialog, container,false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mainActivityViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        operationFragmentViewModel = activity?.let {
            ViewModelProvider(it).get(OperationFragmentViewModel::class.java)

        }
        operationFragmentViewModel?.getAllConsumptionCategory()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { this.loadConsumptionCategoryListToRV(it) })


            btn_back_dialog_select_category_consumption.setOnClickListener(View.OnClickListener {
                findNavController().navigateUp()
            })


        btn_add_dialog_select_category_consumption.setOnClickListener(View.OnClickListener {


            if (editText6.text.toString() != "") {
                operationFragmentViewModel?.insertConsumptionCategory(
                    ConsumptionCategory(
                        editText6.text.toString()))
                editText6.setText("")

            }

            else editText6.setError("Введите название категории")


        })


    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun loadConsumptionCategoryListToRV(it: List<ConsumptionCategory>?) {

        if (it != null) {
            adapter = ConsumptionCategoryItemListAdapter(context!!, it)
            adapter.attachCalback(object : OnConsumptionCategoryClickListener{
                override fun onConsumptionCategoryClick(item: ConsumptionCategory) {

                    operationFragmentViewModel?.setCurrentConsumption(item)
                    findNavController().navigateUp()
                }


            })
            val layoutManager = LinearLayoutManager(context!!)
            recycler_view_category_consumption_dialog.layoutManager = layoutManager
            recycler_view_category_consumption_dialog.adapter = adapter


        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)



    }
}
