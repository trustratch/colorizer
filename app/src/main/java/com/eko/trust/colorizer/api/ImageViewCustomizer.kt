package com.eko.trust.colorizer.api

import android.support.design.widget.FloatingActionButton
import android.widget.ImageView


interface ImageViewCustomizer : ColorInterface.IVC, ColorInterface.FABC {

    fun on(vararg imageViews: ImageView)

    fun on(vararg fabs: FloatingActionButton)

}