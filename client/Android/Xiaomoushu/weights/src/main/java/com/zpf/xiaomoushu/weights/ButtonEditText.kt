package com.zpf.xiaomoushu.weights

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent


class ButtonEditText : BaseEditText {
    companion object {
        private const val TAG = "ButtonEditText"
    }

    private lateinit var mButtonBitmap: Bitmap
    private var mBtnWidth = 0
    private var mBtnPadding = 0
    private var mIsPassword: Boolean = false
    private var mIsButtonVisible = false

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

    @SuppressLint("Recycle")
    override fun init(context: Context, attributeSet: AttributeSet?) {
        super.init(context, attributeSet)
        if (attributeSet != null) {
            val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonEditText)
            for (typeIndex: Int in 0..typeArray.indexCount) {
                when (val attr: Int = typeArray.getIndex(typeIndex)) {
                    R.styleable.ButtonEditText_isPassword -> {
                        mIsPassword = typeArray.getBoolean(attr, false)
                    }
                }
            }
            typeArray.recycle()
        }

        if (!mIsPassword) {
            mButtonBitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.clear)
        }

        mBtnWidth = context.resources.getDimensionPixelSize(R.dimen.btn_edit_text_width)
        mBtnPadding = context.resources.getDimensionPixelSize(R.dimen.btn_edit_text_padding)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mIsPassword) {
            inputType = (InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
        }
        drawButton(canvas)
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        mIsButtonVisible = (!text.isNullOrEmpty()) && isFocused
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            val buttonTouched = (width - mBtnPadding - mBtnWidth < event.x
                    && event.x < width - mBtnPadding
                    && isFocused)
            if (buttonTouched) {
                onClearButtonClick()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun onClearButtonClick() {
        setText("")
    }

    private fun drawButton(canvas: Canvas) {
        if (mIsButtonVisible && !mIsPassword) {
            drawClearButton(canvas)
            invalidate()
        }
    }

    private fun drawClearButton(canvas: Canvas) {
        val scale = 1f
        val top = ((height - mBtnWidth * scale) / 2).toInt()
        val bottom = (top + mBtnWidth * scale).toInt()
        val rect = Rect(
            ((width + scrollX - mBtnPadding - mBtnWidth * (scale + (1f - scale) / 2f)).toInt()),
            top,
            ((width + scrollX - mBtnPadding - mBtnWidth * (1f - scale) / 2f).toInt()),
            bottom
        )
        canvas.drawBitmap(mButtonBitmap, null, rect, mPaint)
    }
}