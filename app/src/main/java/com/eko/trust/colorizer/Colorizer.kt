package com.eko.trust.colorizer

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

import com.eko.trust.colorizer.api.EditTextCustomizer
import com.eko.trust.colorizer.api.ImageViewCustomizer
import com.eko.trust.colorizer.api.TextViewCustomizer
import com.eko.trust.colorizer.api.ViewCustomizer

import java.util.Arrays

import butterknife.ButterKnife


class Colorizer : ViewCustomizer, TextViewCustomizer, ImageViewCustomizer, EditTextCustomizer {

    @ColorInt
    private var color: Int = 0

    private var isSetTextColor = false
    private var isSetHintTextColor = false
    private var isSetBackgroud = false
    private var isSetColorFilter = false


    private fun initWithColor(@ColorInt colorInt: Int): Colorizer {
        this.color = colorInt
        return this
    }

    private fun initWithColorRes(context: Context, @ColorRes colorRes: Int): Colorizer {
        this.color = context.resources.getColor(colorRes)
        return this
    }

    /**
     * Sets the hint text color of the EditText.
     * @see EditText is the class which can be applied

     * @return EditTextCustomizer interface
     */
    override fun toHintTextColor(): EditTextCustomizer {
        isSetHintTextColor = true
        return this
    }

    /**
     * Sets the foreground color of the ImageView.
     * @see ImageView is the class which can be applied

     * @return ImageViewCustomizer interface
     */
    override fun toColorFilter(): ImageViewCustomizer {
        isSetColorFilter = true
        return this
    }

    /**
     * Sets the text color of the TextView.
     * @see TextView is the class which can be applied

     * @return TextViewCustomizer interface
     */
    override fun toTextColor(): TextViewCustomizer {
        isSetTextColor = true
        return this
    }

    /**
     * Sets the background color of the View.
     * @see View is the class which can be applied

     * @return ViewCustomizer interface
     */
    override fun toBackground(): ViewCustomizer {
        isSetBackgroud = true
        return this
    }

    /**
     * Sets the drawable background color of the View.
     * @see View is the class which can be applied

     * @return ViewCustomizer interface
     */
    override fun toBackgroundColorFilter(): ViewCustomizer {
        isSetColorFilter = true
        return this
    }

    /**
     * Sets the whole button color of the FloatingActionButton.
     * @see FloatingActionButton is the class which can be applied

     * @return FABCustomizer interface
     */
    override fun toBackgroundTintList(): ImageViewCustomizer {
        return this
    }

    /**
     * Sets theme of the TabLayout.
     * @see TabLayout is the class which can be applied

     * @return TabLayoutCustomizer interface
     */
    override fun toTabTheme(): ViewCustomizer {
        return this
    }

    /**
     * Applies chosen methods on views
     * @param views array or object of View
     */
    override fun on(vararg views: View) {
        if (isSetColorFilter) {
            ButterKnife.apply(Arrays.asList(*views), ButterKnifeSetter.SET_BACKGROUND_COLOR_FILTER, color)
        } else {
            ButterKnife.apply(Arrays.asList(*views), ButterKnifeSetter.SET_BACKGROUND_COLOR, color)
        }
    }

    /**
     * Applies chosen methods on imageViews
     * @param imageViews array or object of ImageView
     */
    override fun on(vararg imageViews: ImageView) {
        if (isSetBackgroud) {
            ButterKnife.apply(Arrays.asList(*imageViews), ButterKnifeSetter.SET_BACKGROUND_COLOR, color)
        }
        ButterKnife.apply(Arrays.asList(*imageViews), ButterKnifeSetter.SET_COLOR_FILTER, color)
    }

    /**
     * Applies chosen methods on textViews
     * @param textViews array or object of TextView
     */
    override fun on(vararg textViews: TextView) {
        if (isSetBackgroud) {
            ButterKnife.apply(Arrays.asList(*textViews), ButterKnifeSetter.SET_BACKGROUND_COLOR, color)
        }
        ButterKnife.apply(Arrays.asList(*textViews), ButterKnifeSetter.SET_TEXT_COLOR, color)
    }

    /**
     * Applies chosen methods on editTexts
     * @param editTexts array or object of EditText
     */
    override fun on(vararg editTexts: EditText) {
        if (isSetBackgroud) {
            ButterKnife.apply(Arrays.asList(*editTexts), ButterKnifeSetter.SET_BACKGROUND_COLOR, color)
        }
        if (isSetTextColor) {
            ButterKnife.apply(Arrays.asList(*editTexts), ButterKnifeSetter.SET_TEXT_COLOR, color)
        }
        ButterKnife.apply(Arrays.asList(*editTexts), ButterKnifeSetter.SET_HINT_TEXT_COLOR, color)
    }

    /**
     * Applies chosen methods on fabs
     * @param fabs array or object of FloatingActionButton
     */
    override fun on(vararg fabs: FloatingActionButton) {
        ButterKnife.apply(Arrays.asList(*fabs), ButterKnifeSetter.SET_BACKGROUND_TINT_LIST, color)
    }

    /**
     * Applies chosen methods on tabs
     * @param tabs array or object of TabLayout
     */
    override fun on(vararg tabs: TabLayout) {
        ButterKnife.apply(Arrays.asList(*tabs), ButterKnifeSetter.SET_TAB_THEME, color)
    }

    companion object {


        /**
         * @param color the colorInt to paint views
         */
        fun applyColor(@ColorInt color: Int): Colorizer {
            return Colorizer().initWithColor(color)
        }

        /**
         * @param color the color resource to paint views
         */
        fun applyColorRes(context: Context, @ColorRes color: Int): Colorizer {
            return Colorizer().initWithColorRes(context, color)
        }
    }
}
