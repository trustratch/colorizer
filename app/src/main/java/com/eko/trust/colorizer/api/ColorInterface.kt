package com.eko.trust.colorizer.api


class ColorInterface {

    interface VC {
        fun toBackground(): ViewCustomizer
        fun toBackgroundColorFilter(): ViewCustomizer
    }

    interface TVC {
        fun toTextColor(): TextViewCustomizer
    }

    interface ETC {
        fun toHintTextColor(): EditTextCustomizer
    }

    interface IVC {
        fun toColorFilter(): ImageViewCustomizer
    }

    interface FABC {
        fun toBackgroundTintList(): ImageViewCustomizer
    }

    interface TLC {
        fun toTabTheme(): ViewCustomizer
    }

}
