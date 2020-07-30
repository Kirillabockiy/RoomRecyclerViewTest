package com.example.roomrecyclerviewtest.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roomrecyclerviewtest.Reposetories.MoneyAccountRepository

class GraphFragmentViewModel (application: Application) : AndroidViewModel(application){

    private var repository: MoneyAccountRepository = MoneyAccountRepository(application)


    var consumptionDataToGraph = repository.getDataToConsumptionGraph()

    var incomeData = repository.getDataToIncomeGraph()


}