package com.minseok.themeexample

import androidx.annotation.StyleRes

/**
 * Created by minseok on 2020/07/09.
 * ThemeExample.
 */
enum class ThemeItem(@StyleRes val resId: Int) {
    Yellow(R.style.ColorTheme_Yellow),
    Green(R.style.ColorTheme_Green)
}