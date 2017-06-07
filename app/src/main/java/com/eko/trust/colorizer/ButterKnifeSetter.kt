package com.eko.trust.colorizer


import android.app.Application
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


import butterknife.ButterKnife

object ButterKnifeSetter {

    val NO_SETTER: ButterKnife.Setter<out View, Int> = ButterKnife.Setter<View, Int> { view, color, index -> }

    val SET_COLOR_FILTER: ButterKnife.Setter<ImageView, Int> = ButterKnife.Setter<ImageView, Int> { view, color, index -> view.setColorFilter(color!!, PorterDuff.Mode.SRC_ATOP) }

    val SET_TEXT_COLOR: ButterKnife.Setter<TextView, Int> = ButterKnife.Setter<TextView, Int> { view, color, index -> view.setTextColor(color!!) }

    val SET_HINT_TEXT_COLOR: ButterKnife.Setter<EditText, Int> = ButterKnife.Setter<EditText, Int> { view, color, index -> view.setHintTextColor(color!!) }

    val SET_BACKGROUND_COLOR: ButterKnife.Setter<View, Int> = ButterKnife.Setter<View, Int> { view, color, index -> view.setBackgroundColor(color!!) }

    val SET_BACKGROUND_COLOR_FILTER: ButterKnife.Setter<View, Int> = ButterKnife.Setter<View, Int> { view, color, index ->
        if (view.background != null) {
            view.background.setColorFilter(color!!, PorterDuff.Mode.SRC_ATOP)
        } else {
            view.setBackgroundColor(color!!)
        }
    }

    val SET_BACKGROUND_TINT_LIST: ButterKnife.Setter<FloatingActionButton, Int> = ButterKnife.Setter<FloatingActionButton, Int> { fab, color, index -> fab.backgroundTintList = ColorStateList.valueOf(color!!) }

    val SET_TAB_THEME: ButterKnife.Setter<TabLayout, Int> = ButterKnife.Setter<TabLayout, Int> { tab, color, index ->
        tab.setSelectedTabIndicatorColor(color!!)
        tab.setTabTextColors(tab.context.resources.getColor(R.color.colorInactive), color)
    }

}
