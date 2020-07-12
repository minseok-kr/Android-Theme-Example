package com.minseok.themeexample

import android.app.PictureInPictureParams
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.databinding.DataBindingUtil
import com.minseok.themeexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(loadTheme().resId)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.init()
    }

    private fun ActivityMainBinding.init() {
        btnGreen.setOnClickListener {
            ThemeItem.Green.also {
                refreshTheme(it)
            }
        }

        btnYellow.setOnClickListener {
            ThemeItem.Yellow.also {
                refreshTheme(it)
            }
        }
    }

    private fun refreshTheme(item: ThemeItem) {
        saveTheme(item)
        setTheme(item.resId)
        recreate()
    }

    private fun saveTheme(theme: ThemeItem) {
        with(getSharedPreferenceEdit()) {
            putString("theme", theme.name)
        }.commit()
    }

    private fun loadTheme(): ThemeItem {
        return with(getSharedPreference()) {
            getString("theme", ThemeItem.Green.name)!!
        }.run {
            ThemeItem.valueOf(this)
        }
    }

    private fun getSharedPreference()
            = getSharedPreferences("theme-example", Context.MODE_PRIVATE)

    private fun getSharedPreferenceEdit()
            = getSharedPreference().edit()
}

