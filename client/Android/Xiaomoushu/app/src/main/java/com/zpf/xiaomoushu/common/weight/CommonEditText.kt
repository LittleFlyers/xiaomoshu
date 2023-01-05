package com.zpf.xiaomoushu.common.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import com.zpf.xiaomoushu.R


class CommonEditText : AppCompatEditText {
    companion object {
        private const val TAG = "OnBoardingEditText"
        private const val TEXT_LEFT_PADDING = 5
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val ROUND_RECT_LINE_WIDTH = 4f
        private const val RX = 20f
        private const val RY = 20f
    }

    private lateinit var mPaint: Paint
    private var mBorderColor: Int = Color.WHITE

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context, attributeSet, defStyleAttr
    ) {
        init(context, attributeSet)
    }

    @SuppressLint("ResourceType")
    private fun init(context: Context, attributeSet: AttributeSet?) {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
        mPaint.color = Color.WHITE
        if (attributeSet != null) {
            val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.CommonEditText)
            for (typeIndex: Int in 0..typeArray.indexCount) {
                when (val attr: Int = typeArray.getIndex(typeIndex)) {
                    R.styleable.CommonEditText_borderColor -> {
                        mBorderColor = typeArray.getColor(attr, DEFAULT_BORDER_COLOR)
                    }
                }
            }
            typeArray.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setPadding(paddingLeft + TEXT_LEFT_PADDING, paddingTop, paddingRight, paddingBottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.style = Paint.Style.STROKE
        mPaint.color = mBorderColor
        setTextColor(Color.WHITE)
        drawBorder(canvas)
        background = null
    }

    private fun drawBorder(canvas: Canvas) {
        val width = width
        val height = height

        val roundRectLineWidth = ROUND_RECT_LINE_WIDTH

        mPaint.strokeWidth = roundRectLineWidth
        canvas.drawRoundRect(
            roundRectLineWidth / 2,
            roundRectLineWidth / 2,
            width - roundRectLineWidth / 2,
            height - roundRectLineWidth / 2,
            RX,
            RY,
            mPaint
        )
    }
}