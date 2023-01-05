package com.zpf.xiaomoushu.common.weight

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText

class CommonEditText : AppCompatEditText {
    companion object {
        private const val TAG = "OnBoardingEditText"
    }

    private lateinit var mPaint: Paint

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init()
    }

    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
        mPaint.color = Color.WHITE
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setPadding(paddingLeft + 5, paddingTop, paddingRight, paddingBottom);
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.style = Paint.Style.STROKE
        setTextColor(Color.WHITE)
        drawBorder(canvas)
        background = null
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        Log.d(TAG, "onTextChanged: $text")
    }

    private fun drawBorder(canvas: Canvas) {
        val width = width
        val height = height

        val roundRectLineWidth = 4f

        mPaint.strokeWidth = roundRectLineWidth
        canvas.drawRoundRect(
            roundRectLineWidth / 2,
            roundRectLineWidth / 2,
            width - roundRectLineWidth / 2,
            height - roundRectLineWidth / 2,
            20f,
            20f,
            mPaint
        )
    }
}