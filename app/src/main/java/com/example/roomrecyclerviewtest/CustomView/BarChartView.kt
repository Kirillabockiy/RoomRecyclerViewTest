package com.example.roomrecyclerviewtest.CustomView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.roomrecyclerviewtest.R
import kotlin.random.Random

class BarChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var bcv_circleColor : Int = 0
    private var paint: Paint = Paint()
    private var paintline: Paint = Paint()
    private var width_bar: Float = 0F
    private var current_width: Float = 0F
    private var height_bar: Float = 0F
    private var interval: Float = 0F
    private var list: ArrayList<Bar> = ArrayList()
    private var total : Double = 0.0
    val colors: ArrayList<Int> = ArrayList()

//
//
//    private fun setupAttributes(attrs: AttributeSet) {
//
//
//    }

    fun setList(list: List<Bar>) {

        this.list.clear()
        this.list.addAll(list)

        total = (this.list[0].value + 300).toDouble()
        invalidate()
    }


    init {

        paintline.setColor(Color.LTGRAY)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BarChartView,
            0, 0).apply {

            try {
                bcv_circleColor = getInt(R.styleable.BarChartView_rect_color, Color.GREEN)
                colors.add(getInt(R.styleable.BarChartView_firstBarColor, Color.parseColor("#57CCDE")))
                colors.add(getInt(R.styleable.BarChartView_secondBarColor, Color.parseColor("#92FC97")))
                colors.add(getInt(R.styleable.BarChartView_thirdBarColor, Color.parseColor("#FFF863")))
                colors.add(getInt(R.styleable.BarChartView_fourthBarColor, Color.parseColor("#827ED9")))
                colors.add(getInt(R.styleable.BarChartView_fifthBarColor, Color.parseColor("#E5A9FC")))
                colors.add(getInt(R.styleable.BarChartView_sixthBarColor, Color.parseColor("#496D89")))
                colors.add(getInt(R.styleable.BarChartView_seventhBarColor, Color.parseColor("#8EBF5F")))
                colors.add(getInt(R.styleable.BarChartView_eighthBarColor, Color.parseColor("#499272")))
                colors.add(getInt(R.styleable.BarChartView_ninthBarColor, Color.parseColor("#496D89")))
                colors.add(getInt(R.styleable.BarChartView_tenthBarColor, Color.parseColor("#D4986A")))

            } finally {
                recycle()
            }
        }


    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val viewHeightHalf = this.measuredHeight
        val viewWidthHalf = this.measuredWidth
        val r = 25
        val wq = viewWidthHalf / r
        val hq = viewHeightHalf / r

        //draw horizontal lines
        for (i in 1..hq) {
            canvas?.drawLine(1f, (i * r).toFloat(), viewWidthHalf.toFloat(),
                (i * r).toFloat(), paintline)
        }

        //draw vertical lines
        for (i in 1..wq) {
            canvas?.drawLine((i * r).toFloat(), 1f, (i * r).toFloat() , viewHeightHalf.toFloat()
                , paintline)

        }


    if (!this.list.isEmpty()) {
        var q = this.list.size
        width_bar = (viewWidthHalf  / 12).toFloat()
        interval = (viewWidthHalf - (width_bar * q))/(q+1)
        paint.setStyle(Paint.Style.FILL)
        paint.setAntiAlias(true)
        current_width = interval

        for (i in 0..list.size - 1) {

            height_bar = ((viewHeightHalf / total ) * list[i].value).toFloat()

            paint.setColor(list[i].colorBar)
            canvas?.drawRect(current_width, viewHeightHalf - height_bar, current_width+width_bar, viewHeightHalf.toFloat(), paint)

            current_width = current_width +  width_bar + interval


        }


    }

    }
}

data class Bar(
    val value: Float,
    val colorBar: Int

)