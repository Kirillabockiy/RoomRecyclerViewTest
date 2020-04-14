package com.example.roomrecyclerviewtest


//import com.example.roomrecyclerviewtest.ViewModels.MessageViewModel


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
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

        setUpNavigation()



//        val navController = findNavController(R.id.nav_host_fragment)
//        Navigation.setViewNavController(fab, navController)
//        fab.setOnClickListener {
////            navController.navigate(R.id.action_global_fragmentAddMoneyAccount)
//            navController.navigate(R.id.action_global_addTransactionBottomSheetFragment)
////            fab.hide()
//
//        }



//

    }

    fun setUpNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)

//        var appBarConfig = AppBarConfiguration(
//            setOf(
//                R.id.overviewFragment,
//                R.id.accountsMainFragment,
//                R.id.operationsFragment,
//                R.id.moreFunctionsFragment
//            )
//        )
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
//        NavigationUI.setupWithNavController(
//            bottom_navigation,
//            navHostFragment!!.navController
//        )


    }

}
