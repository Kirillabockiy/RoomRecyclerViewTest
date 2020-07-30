package com.example.roomrecyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomrecyclerviewtest.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_add_operation_transfer.*


class AddOperationTransferFragment : Fragment() {

    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_operation_transfer, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel?.viewState?.observe(viewLifecycleOwner, Observer {

            if(it.isLoading == true) {

                progressBar.visibility = View.VISIBLE
            }
            else {

                progressBar.visibility = View.GONE
            }
        })


        btn_load_accounts.setOnClickListener(View.OnClickListener {

            mainActivityViewModel?.reverse()
        })

    }
}
