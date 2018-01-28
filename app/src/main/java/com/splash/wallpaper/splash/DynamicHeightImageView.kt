package com.splash.wallpaper.splash

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec
import android.widget.ImageView


/**
 * Created by lenovo on 1/27/2018.
 */
class DynamicHeightImageView : ImageView {

    var heightRatio: Double = 0.toDouble()
        set(ratio) {
            if (ratio != heightRatio) {
                field = ratio
                requestLayout()
            }
        }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context) : super(context) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (heightRatio > 0.0) {
            // set the image views size
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = (width * heightRatio).toInt()
            setMeasuredDimension(width, height)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}