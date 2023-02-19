package com.zpf.xiaomoushu.weights.edittext

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TextView.BufferType

class VerifyCodeEditText : ViewGroup {
    private lateinit var dynamicTextView: TextView
    private lateinit var editText: BaseEditText

    private


    constructor(context: Context?) : super(context) {
    }

    @SuppressLint("CustomViewStyleable")
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        editText = BaseEditText(context, attributeSet)
        dynamicTextView = TextView(context)
        addView(editText)
//        addView(dynamicTextView)
        dynamicTextView.text = "AAAAAABBBBB"
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams? {
        return super.generateLayoutParams(p)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        if (childCount > 0) {
            val count = childCount
            for (i in 0 until count) {
                val child = getChildAt(i)
                child.measure(
                    widthMeasureSpec, 10
                )
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        Log.d(TAG, "onLayout: father ${l} height ${t}")
        val count = childCount
        val parentWith = (parent as ViewGroup).width
        val parentHeight = (parent as ViewGroup).height
        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child is BaseEditText) {
                child.layout(0, 0, parentWith, parentHeight)
            } else if (child is TextView) {
                val left = r - child.width
                child.layout(left, 0, 0, 0)
            }
        }
    }

    fun getDynamicTextView(): Editable {
        val text: CharSequence = dynamicTextView.text
        // This can only happen during construction.
        // This can only happen during construction.
        if (text is Editable) {
            return (dynamicTextView.text as Editable?)!!
        }
        dynamicTextView.setText(text, BufferType.EDITABLE)
        return (dynamicTextView.text as Editable?)!!
    }

    companion object {
        private const val TAG = "DynamicTextEditText"
    }
}