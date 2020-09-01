package com.padcmyanmar.androidftc.shared.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.androidftc.shared.R

class StraightProgressBar @JvmOverloads constructor(
    context: Context,attrs:AttributeSet,defStyleAttr:Int=0
    ) : View(context,attrs,defStyleAttr){
    private val paintBg = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var lightColor = Color.LTGRAY
    private var darkColor = rgb(89,214,178)
    private val borderWidth = 30f
    private var percent = 0f

    init {
        setUpAttributes(attrs)
        setUpValues()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f,height.toFloat(),width.toFloat(),height.toFloat(),paintBg)
        if(percent!=0f){
            canvas?.drawLine(0f,height.toFloat(),width*percent*0.01f,height.toFloat(),paint)
        }
    }
    private fun setUpAttributes(attrs:AttributeSet) {
        context.withStyledAttributes(attrs,
            R.styleable.StraightProgressBar
        ) {
            percent = getFloat(R.styleable.StraightProgressBar_barPercent,0f)
            darkColor = getColor(R.styleable.StraightProgressBar_barColor,darkColor)
        }
    }
    private fun setUpValues() {
        paintBg.color = lightColor
        paintBg.style = Paint.Style.STROKE
        paintBg.strokeWidth = borderWidth

        paint.color = darkColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
    }
    fun setBarColor(color:Int) {
        darkColor = color
    }
    fun setBarPercentage(percentage:Float) {
        percent = percentage
    }
}
