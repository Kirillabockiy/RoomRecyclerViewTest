package com.example.roomrecyclerviewtest.ViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.Helper.IDTypeMoneyAccount
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository
import com.kirillabockiy.examplemvvmapp.Model.CardItem
import com.kirillabockiy.examplemvvmapp.Model.CashItem
import com.kirillabockiy.examplemvvmapp.Model.HeaderItem
import com.kirillabockiy.examplemvvmapp.Model.MoneyAccountListForRV
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MoneyAccountListViewModel (application: Application) : AndroidViewModel(application)
     {


         data class ViewState(

             val isLoading: Boolean = true
//             val isEmptyList: Boolean = false
//             val itemList: ArrayList<MoneyAccountListForRV>? = null


         )


         private var repository: MoneyAccountRepository = MoneyAccountRepository(application)

         val listForRV: MutableLiveData<ArrayList<MoneyAccountListForRV>> = MutableLiveData()

         val mAllMoneyAccount : LiveData<List<MoneyAccount>> = repository.getAllMoneyAccounts()

         val viewState: MutableLiveData<ViewState> = MutableLiveData()



         fun currentViewState() : ViewState = viewState.value!!

         fun loadingStarted() {

             viewState.value = currentViewState().copy(isLoading = true)

         }

         fun loadingFinished() {

             viewState.value = currentViewState().copy(isLoading = false)
         }



         val moneyAccountListForRV: LiveData<ArrayList<MoneyAccountListForRV>>? = Transformations.switchMap(mAllMoneyAccount) {
                 mAllMoneyAccount -> convertMoneyAccountListToListFromRv(mAllMoneyAccount)
         }

         fun convertMoneyAccountListToListFromRv(moneyAccountList: List<MoneyAccount>?) : LiveData<ArrayList<MoneyAccountListForRV>> {

//             loadingStarted()

             val mainListForRV: ArrayList<MoneyAccountListForRV> = ArrayList()
             val cardListForRV: ArrayList<MoneyAccountListForRV> = ArrayList()
             val cashListForRV: ArrayList<MoneyAccountListForRV> = ArrayList()
             val bankListForRV: ArrayList<MoneyAccountListForRV> = ArrayList()
             val targetListForRV: ArrayList<MoneyAccountListForRV> = ArrayList()

             var overallBalance = 0
             moneyAccountList?.let{



                 it.forEach{
                     overallBalance += Integer.parseInt(it.current_balance)

                     if (it.accountType == IDTypeMoneyAccount.TYPE_CARD_MONEY_ACCOUNT)
                         cardListForRV.add(CardItem(it.id, it.title, it.bank_name, it.card_number, it.current_balance + " ₽"))
                     if (it.accountType == IDTypeMoneyAccount.TYPE_CASH_MONEY_ACCOUNT)
                         cashListForRV.add(CashItem(it.id, it.title, it.current_balance + " ₽"))

                 } ?: run {

                     Log.i("ERROR", "Money account list = Null")
                 }


                     fun addHeaderItem(list: ArrayList<MoneyAccountListForRV>, s: String) {

                         list.add(0, HeaderItem(s))
                         mainListForRV.addAll(list)
                         list.clear()
                     }

                 if(!cardListForRV.isEmpty())
                     addHeaderItem(cardListForRV, "Карты")

                 if(!cashListForRV.isEmpty())
                     addHeaderItem(cashListForRV, "Наличные")

                 if(!bankListForRV.isEmpty())
                     addHeaderItem(bankListForRV, "Счета")

                 if(!targetListForRV.isEmpty())
                     addHeaderItem(targetListForRV, "Цели")

                 if(!mainListForRV.isEmpty()) {

                     mainListForRV.add(0, HeaderItem("Общий баланс " + overallBalance + " ₽"))
                 }

             }
             this.listForRV.value = mainListForRV




//                 loadingFinished()



             return this.listForRV

         }



//    val viewState: MutableLiveData<ViewState> = MutableLiveData()



//    private fun currentViewState(): ViewState = viewState.value!!

    init {
        viewState.value = ViewState()
    }



    fun deleteMoneyAccountById(id: String) {

        viewModelScope.launch {
            repository.deleteMoneyAccountById(id)
        }

    }



}