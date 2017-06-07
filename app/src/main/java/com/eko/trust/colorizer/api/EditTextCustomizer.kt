package com.eko.trust.colorizer.api

import android.widget.EditText


interface EditTextCustomizer : ColorInterface.ETC {

    fun on(vararg editTexts: EditText)

}