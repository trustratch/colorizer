package com.eko.trust.colorizer.api

import android.widget.TextView


interface TextViewCustomizer : ColorInterface.TVC, ColorInterface.ETC {

    fun on(vararg textViews: TextView)
}