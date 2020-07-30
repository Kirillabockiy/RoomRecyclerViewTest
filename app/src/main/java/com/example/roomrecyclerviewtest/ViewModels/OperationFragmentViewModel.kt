package com.example.roomrecyclerviewtest.ViewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomrecyclerviewtest.DataBase.Entity.ConsumptionCategory
import com.example.roomrecyclerviewtest.DataBase.Entity.MoneyAccount
import com.example.roomrecyclerviewtest.DataBase.Entity.Operation
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class OperationFragmentViewModel  (application: Application) : AndroidViewModel(application) {

    private var repository: MoneyAccountRepository = MoneyAccountRepository(application)

    var mAllMoneyAccount : LiveData<List<MoneyAccount>>? = null

    var currentOperation: Operation? = null


    var currentConsumptioncategory : MutableLiveData<ConsumptionCategory> = MutableLiveData<ConsumptionCategory>()
    fun setDefaultConsumptionCategory(){

        viewModelScope.launch {

            currentConsumptioncategory.value = repository.getConsumptionCategoryByMaxRating() }

    }

    var mAllConsumptionCategory: LiveData<List<ConsumptionCategory>>? = null


    fun getCurrentConsumptionCategory(): LiveData<ConsumptionCategory>? {

        return currentConsumptioncategory

    }

    fun setCurrentConsumption(item: ConsumptionCategory?) {

        currentConsumptioncategory.value = item
    }


    fun getAllConsumptionCategory(): LiveData<List<ConsumptionCategory>>? {
        if (mAllConsumptionCategory == null) {

            mAllConsumptionCategory = repository.getAllConsumptionCategory()

        }

        return mAllConsumptionCategory

    }

    fun insertConsumptionCategory(consumptionCategory: ConsumptionCategory) {
        viewModelScope.launch {
            repository.insertConsumptionCategory(consumptionCategory)

        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("VIEW_MODEL_LIFECYCLE", "OperationFragmentViewModel OnCleared")
    }
}