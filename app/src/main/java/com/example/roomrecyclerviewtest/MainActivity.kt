package com.example.roomrecyclerviewtest


import android.os.Bundle

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.roomrecyclerviewtest.Models.MoneyAccount
//import com.example.roomrecyclerviewtest.ViewModels.MessageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val DEFAULT_MSG_LENGTH_LIMIT = 100
//
//    private var messageViewModel: MessageViewModel? = null
//
//    lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val navController = findNavController(R.id.nav_host_fragment)
        Navigation.setViewNavController(fab, navController)
        fab.setOnClickListener {
            navController.navigate(R.id.action_global_fragmentAddMoneyAccount)
        }

//        fab.setOnClickListener(View.OnClickListener {
//            navController.navigate(R.id.action_global_fragmentAddMoneyAccount)
//
//        })

//        messageViewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)
//
//        messageViewModel?.getMessages()?.observe(this, Observer<List<MoneyAccount>> { this.renderMessges(it) })
//
//
//
//        // Enable Send button when there's text to send
//        edit_message_text.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//
//            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                send_message_button.isEnabled = charSequence.toString().trim { it <= ' ' }.isNotEmpty()
//            }
//
//            override fun afterTextChanged(editable: Editable) {}
//        })
//        edit_message_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT))
//
//        // Send button sends a message and clears the EditText
//        send_message_button.setOnClickListener {
//            val message = MoneyAccount(0,edit_message_text.getText().toString())
//
//            messageViewModel?.setMessage(message)
//            // Clear input box
//            edit_message_text.setText("")
//        }
//
//        delete_button.setOnClickListener(View.OnClickListener {
//
//            messageViewModel?.deleteAllMessage()
//        })

    }

//    private fun renderMessges(moneyAccounts: List<MoneyAccount>?){
//        adapter = MessageAdapter(this,moneyAccounts)
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.stackFromEnd = true
//        message_recycler_view.layoutManager = layoutManager
//        message_recycler_view.adapter = adapter
//        message_recycler_view.smoothScrollToPosition(message_recycler_view.adapter!!.itemCount)
//
//    }

}
