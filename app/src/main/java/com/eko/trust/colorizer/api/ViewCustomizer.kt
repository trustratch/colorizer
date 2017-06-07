package com.eko.trust.colorizer.api


import android.support.design.widget.TabLayout
import android.view.View


interface ViewCustomizer : ColorInterface.VC, ColorInterface.TVC, ColorInterface.ETC, ColorInterface.IVC, ColorInterface.TLC {

    fun on(vararg views: View)

    fun on(vararg tabs: TabLayout)

}