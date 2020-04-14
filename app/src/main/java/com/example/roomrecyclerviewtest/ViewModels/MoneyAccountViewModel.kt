package com.example.roomrecyclerviewtest.ViewModels


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomrecyclerviewtest.Models.CardMoneyAccount
import com.example.roomrecyclerviewtest.Models.CashMoneyAccount
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository
import com.kirillabockiy.examplemvvmapp.Model.CardItem
import com.kirillabockiy.examplemvvmapp.Model.CashItem
import com.kirillabockiy.examplemvvmapp.Model.HeaderItem
import com.kirillabockiy.examplemvvmapp.Model.RVItemType
import kotlinx.coroutines.launch


class MoneyAccountViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: MoneyAccountRepository = MoneyAccountRepository(application)

    var data: MutableLiveData<ArrayList<RVItemType>>? = null

    fun getData(): LiveData<ArrayList<RVItemType>>? {
        if (data == null) {
            data = MutableLiveData()

        }
        getMoneyAccountList()
        return data
    }

    fun getMoneyAccountList() {
        val itemList: ArrayList<RVItemType> = ArrayList()

        var balance: Int = 0

        viewModelScope.launch {

            val cashMoneyAccountList = repository.getCashMoneyAccountList()
            val cardMoneyAccountList = repository.getCardMoneyAccountList()

            if (cardMoneyAccountList != null) {
                if (!cardMoneyAccountList.isEmpty()) {
                    itemList.add(HeaderItem("Карты"))
                    cardMoneyAccountList.forEach {
                        itemList.add(
                            CardItem(
                                id = it.id,
                                title = it.title,
                                bankName = it.bankName,
                                cardNumber = it.cardNumber,
                                balance = it.balance
                            )
                        )

                        balance += it.balance.toInt()

                    }
                }
            }

            if(cashMoneyAccountList != null) {
                if (!cashMoneyAccountList.isEmpty()) {
                    itemList.add(HeaderItem("Наличные"))
                    cashMoneyAccountList.forEach {
                        itemList.add(
                            CashItem(
                                id = it.id,
                                title = it.title,
                                balance = it.balance
                            )
                        )

                        balance += it.balance.toInt()
                    }

                }
            }



            if (!itemList.isEmpty()) {

                itemList.add(0 , HeaderItem("Общий баланс " + balance.toString() + "₽"))
            }



            data?.postValue(itemList)

        }
//
    }

    fun deleteCashMoneyAccount(id: String) = viewModelScope.launch {


            repository.deleteCashMoneyAccount(id)
            getMoneyAccountList()




    }
    fun deleteCardMoneyAccount(id: String) = viewModelScope.launch {


        repository.deleteCardMoneyAccount(id)
        getMoneyAccountList()




    }

    fun insertCardMoneyAccount(mCardItem: CardMoneyAccount){
        viewModelScope.launch {
            repository.insertCardMoneyAccount(mCardItem)
        }


    }

    fun insertCashMoneyAccount(mCashItem: CashMoneyAccount){
        viewModelScope.launch {
            repository.insertCashMoneyAccount(mCashItem)
        }


    }




}