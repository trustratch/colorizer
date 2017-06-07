package com.eko.trust.colorizer

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        color = resources.getColor(R.color.colorAccent)
        refreshView()
        textview_container.setOnClickListener {
            generateColor()
            colorizeTextViews()
        }

        imageview_container.setOnClickListener {
            generateColor()
            colorizeImageViews()
        }

        fab.setOnClickListener {
            generateColor()
            colorizeFab()
        }
    }

    fun generateColor(){
        val rnd :Random = Random()
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    fun refreshView(){
        colorizeTextViews()
        colorizeFab()
        colorizeImageViews()
    }

    fun colorizeTextViews() {
        Colorizer.applyColor(color)
                .toTextColor()
                .on(text_view1, text_view2, text_view3)
    }

    fun colorizeFab() {
        Colorizer.applyColor(color)
                .toBackgroundTintList()
                .on(fab)
    }

    fun colorizeImageViews() {
        Colorizer.applyColor(color)
                .toColorFilter()
                .on(image_view1, image_view2, image_view3)
    }

}


