package com.example.roomrecyclerviewtest.ViewModels


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomrecyclerviewtest.DataBase.Entity.*
import com.example.roomrecyclerviewtest.Models.MoneyAccountMin
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivityViewModel (application: Application) : AndroidViewModel(application) {

    data class ViewState(

        val isLoading: Boolean = false


    )

    var currentConsumptioncategory : MutableLiveData<ConsumptionCategory> = MutableLiveData<ConsumptionCategory>()



    override fun onCleared() {
        super.onCleared()

        currentConsumptioncategory.value = null
        Log.i("VIEW_MODEL_LIFECYCLE", "ViewModel OnCleared")
    }

    val viewState: MutableLiveData<ViewState> = MutableLiveData()

    init {
        viewState.value = ViewState()
    }

    private var repository: MoneyAccountRepository = MoneyAccountRepository(application)


    var mAllMoneyAccount : LiveData<List<MoneyAccount>>? = null
    var mBankNameList : LiveData<List<Bank>>? = null

    var mAllOperation: LiveData<List<Operation>>? = null


    var currentMoneyAccount: MoneyAccount? = null
    var mAllIncomeCategory: LiveData<List<IncomeCategory>>? = null

    var mMoneyAccountList: LiveData<List<MoneyAccountMin>>? = null

    var mAllConsumptionCategory: LiveData<List<ConsumptionCategory>>? = null



    fun getCurrentConsumptionCategory(): LiveData<ConsumptionCategory>? {

    return currentConsumptioncategory

    }

    fun setCurrentConsumption(item: ConsumptionCategory) {

        currentConsumptioncategory.setValue(item)
    }




    fun getMoneyAccountList(): LiveData<List<MoneyAccountMin>>? {
        if (mMoneyAccountList == null) {

            mMoneyAccountList = repository.getMoneyAccountList()
        }

        return mMoneyAccountList

    }

    fun getAllIncomeCategory(): LiveData<List<IncomeCategory>>? {
        if (mAllIncomeCategory == null) {

            mAllIncomeCategory = repository.getAllIncomeCategory()
        }

        return mAllIncomeCategory

    }

    fun getAllConsumptionCategory(): LiveData<List<ConsumptionCategory>>? {
        if (mAllConsumptionCategory == null) {

            mAllConsumptionCategory = repository.getAllConsumptionCategory()

        }

        return mAllConsumptionCategory

    }

    fun getAllOperations(): LiveData<List<Operation>>? {
        if (mAllOperation == null) {

            mAllOperation = repository.getAllOperations()
        }

        return mAllOperation

    }

    fun getBankList(): LiveData<List<Bank>>? {
        if (mBankNameList == null) {

            mBankNameList = repository.getBankList()
        }

        return mBankNameList

    }



    fun reverse(){
        if (viewState.value?.isLoading == false) {
            viewState.value = currentViewState().copy(isLoading = true)
        } else {
            viewState.value = currentViewState().copy(isLoading = false)

        }



    }
    private fun currentViewState(): ViewState = viewState.value!!


    fun getAllMoneyAccount(): LiveData<List<MoneyAccount>>? {
        if (mAllMoneyAccount == null) {
            mAllMoneyAccount = repository.getAllMoneyAccounts()

        }

        return mAllMoneyAccount
    }



    fun getMoneyAccountById(id: String) {
        viewState.value = currentViewState().copy(isLoading = true)

        viewModelScope.launch {
            currentMoneyAccount = repository.getMoneyAccountById(id)

            delay(500)
            viewState.value = currentViewState().copy(isLoading = false)
        }

    }

    fun insertOperationAndUpdateMoneyAccount(operation: Operation, moneyAccount: MoneyAccount) {

        viewModelScope.launch {
            repository.insertTransactionAndUpdateMoneyAccount(operation, moneyAccount)

        }
    }

    fun insertIncomeCategory(incomeCategory: IncomeCategory) {
        viewModelScope.launch {
            repository.insertIncomeCategory(incomeCategory)

        }
    }
    fun insertConsumptionCategory(consumptionCategory: ConsumptionCategory) {
        viewModelScope.launch {
            repository.insertConsumptionCategory(consumptionCategory)

        }
    }

    fun insertMoneyAccount(moneyAccount: MoneyAccount) {
        viewModelScope.launch {
            repository.insertMoneyAccount(moneyAccount)

        }
    }

    fun insertBank(bank: Bank) {
        viewModelScope.launch {
            repository.insertBank(bank)

        }

    }




}