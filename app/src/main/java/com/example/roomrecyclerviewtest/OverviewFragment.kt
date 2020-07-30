package com.example.roomrecyclerviewtest



import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.roomrecyclerviewtest.CustomView.Bar
import com.example.roomrecyclerviewtest.ViewModels.GraphFragmentViewModel

import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_overview.*
import kotlin.random.Random


class OverviewFragment : Fragment() {

//    val list : ArrayList<ConsumptionsFromMounts> = ArrayList()

    val colors: ArrayList<Int> = ArrayList()




    val graphFragmentViewModel  by viewModels<GraphFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)


//
//        list.add(ConsumptionsFromMounts("Супермаркет", 5235F))
//        list.add(ConsumptionsFromMounts("Кафе", 2500F))
//        list.add(ConsumptionsFromMounts("Интернет", 2050F))
//        list.add(ConsumptionsFromMounts("Фитнес", 1478F))
//        list.add(ConsumptionsFromMounts("Аптека", 1247F))
//
//        list.add(ConsumptionsFromMounts("Остальное", 850F))


//
//        colors.add(Color.parseColor("#92FC97"))
//        colors.add(Color.parseColor("#57CCDE"))
//        colors.add(Color.parseColor("#FFF863"))
//        colors.add(Color.parseColor("#827ED9"))
//        colors.add(Color.parseColor("#E5A9FC"))
//        colors.add(Color.parseColor("#496D89"))
//        colors.add(Color.parseColor("#8EBF5F"))
//        colors.add(Color.parseColor("#499272"))
//        colors.add(Color.parseColor("#496D89"))
//        colors.add(Color.parseColor("#D4986A"))

//
//        val entries: MutableList<PieEntry> = ArrayList()
//        entries.add(PieEntry(18.5f, "Green"))
//        entries.add(PieEntry(26.7f, "Yellow"))
//        entries.add(PieEntry(24.0f, "Red"))
//        entries.add(PieEntry(30.8f, "Blue"))
//        val set = PieDataSet(entries, "Election Results")
//        val data = PieData(set)
//        pie_chart.data
//        pie_chart.invalidate() // refresh


        graphFragmentViewModel.consumptionDataToGraph.observe(viewLifecycleOwner, Observer {
            setDataToConsumptionGraph(it)})

        graphFragmentViewModel.incomeData.observe(viewLifecycleOwner, Observer { setDataToIncomeGraph(it) })



        return view
    }

    @SuppressLint("SetTextI18n")
    private fun setDataToIncomeGraph(list: List<IncomeDataToGraph>) {
        var summ = 0

        if (!list.isEmpty()) {


            list.forEach {
                summ += it.summ
                val chip = Chip(chip_group2.context)
                chip.text = it.income_category + ": " + it.summ + "₽"

                chip_group2.addView(chip)

            }


        }
        txt_summ_income.text = "" + summ + "₽"

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





//        setDataToConsumptionGraph(list)






    }


    fun setDataToConsumptionGraph(list : List<ConsumptionDataToGraph>) {
        var totalSumm = 0F
        var summ = 0

        var a: ArrayList<Bar> = ArrayList()

        if (!list.isEmpty()) {
            val sortedList = list.sortedByDescending { it.summ }
            for (i in 0..sortedList.size-1) {

                summ += sortedList[i].summ

                val randColor = Color.argb(
                    255,
                    Random.nextInt(100, 255),
                    Random.nextInt(100, 255),
                    Random.nextInt(100, 255)
                )
                a.add(Bar(sortedList[i].summ.toFloat(), randColor))


                val chip = Chip(chip_group.context)
                chip.text = sortedList[i].consumption_category + ": " + sortedList[i].summ + "₽"
                chip.chipBackgroundColor = ColorStateList.valueOf(randColor)
                chip_group.addView(chip)
            }

            textView12.text = "-" + summ + "₽"
            bar_char_view.setList(a)



        }


    }
}

data class ConsumptionsFromMounts(
    val label: String,
    val summ: Float


)

data class ConsumptionDataToGraph(

    val summ: Int,
    val consumption_category: String

)

data class IncomeDataToGraph(

    val summ: Int,
    val income_category: String

)
