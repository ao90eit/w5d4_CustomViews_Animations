package com.aoinc.w5d4_customviews_animations.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View

class RoundedButton(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet) {
    // How do I create a custom view?
    // Extend from the View class and override the onDraw method

    private var paint = Paint()

    val circleRadius = 300f
    val circleColor = Color.MAGENTA
    val textColor = Color.WHITE
    var buttonText = "Start"
    var midXPercent = 0.5f
    var midYPercent = 0.5f

    var offsetX = 10
    var curX = 0
    var offsetY = 10
    var curY = 0

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var midX = midXPercent * width
        var midY = midYPercent * height

        curX += offsetX
        curY += offsetY
//        Log.d("TAG_X", "x = $offsetX")
//        Log.d("TAG_X", "y = $offsetY")

        paint.apply {
            color = circleColor
        }

        canvas.drawCircle(midX + curX, midY + curY, circleRadius, paint)

        if (midX + curX + circleRadius > width || midX + curX - circleRadius < 0)
            offsetX *= -1
        if (midY + curY + circleRadius > height || midY + curY - circleRadius < 0)
            offsetY *= -1

        val size = circleRadius / 2f
//        val size = 60f

        paint.apply {
            color = Color.WHITE
            textSize = size
        }

        var textBounds = Rect()
        paint.getTextBounds(buttonText, 0, buttonText.length, textBounds)

        val xPos = midX - (textBounds.width()/2f)
        val yPos = midY + (textBounds.height()/3f)

//        Log.d("TAG_X", textBounds.toString())
//        Log.d("TAG_X", "height = ${textBounds.height()}")
//        Log.d("TAG_X", "width = ${textBounds.width()}")

        canvas.drawText(buttonText, xPos + curX, yPos + curY, paint)
        invalidate()
    }
}