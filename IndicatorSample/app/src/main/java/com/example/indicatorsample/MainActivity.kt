package com.example.indicatorsample

import android.content.res.ColorStateList
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.indicatorsample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.apply {
            lineIndicatorValue()
            setLineIndicatorButtonListener()
            //set two color in LineIndicator
            lineProgressTwoColor.setIndicatorColor(this@MainActivity.getColor(R.color.md_theme_primary),this@MainActivity.getColor(R.color.md_theme_error))
            circleIndicatorValue()
            setCircleIndicatorButtonListener()
            circleProgressTwoColor.setIndicatorColor(this@MainActivity.getColor(R.color.md_theme_primary),this@MainActivity.getColor(R.color.md_theme_error))

        }
    }

    private fun lineIndicatorValue() {
        b.lineProgress.max = 100
        lifecycleScope.launch {
            while (true) {
                delay(50)
                b.lineProgress.progress = b.lineProgress.progress + 1
                if (b.lineProgress.progress == b.lineProgress.max) {
                    delay(2000)
                    b.lineProgress.progress = 0
                }
            }
        }
    }

    private fun circleIndicatorValue() {
        b.circleIndicator.max = 100
        lifecycleScope.launch {
            while (true) {
                delay(50)
                b.circleIndicator.progress = b.circleIndicator.progress + 1
                if (b.circleIndicator.progress == b.circleIndicator.max) {
                    delay(2000)
                    b.circleIndicator.progress = 0
                }
            }
        }
    }
    private fun setLineIndicatorButtonListener(){
        var isLine1Hide = false
        var isLine2Hide = false
        b.apply {
            lineHide1.setOnClickListener {
                if (!isLine1Hide){
                    lineProgress.hide()
                    isLine1Hide = true
                    lineHide1.text = "Show"
                }
                else{
                    lineProgress.show()
                    isLine1Hide = false
                    lineHide1.text = "Hide"
                }
            }
            lineHide2.setOnClickListener {
                if (!isLine2Hide){
                    lineProgressIndeterminate.hide()
                    isLine2Hide = true
                    lineHide2.text = "Show"
                }
                else{
                    lineProgressIndeterminate.show()
                    isLine2Hide = false
                    lineHide2.text = "Hide"
                }
            }
        }
    }
    private fun setCircleIndicatorButtonListener(){
        var isCircle1Hide = false
        var isCircle2Hide = false
        b.apply {
            circleHide1.setOnClickListener {
                if (!isCircle1Hide){
                    circleIndicator.hide()
                    isCircle1Hide = true
                    circleHide1.text = "Show"
                }
                else{
                    circleIndicator.show()
                    isCircle1Hide = false
                    circleHide1.text = "Hide"
                }
            }
            circleHide2.setOnClickListener {
                if (!isCircle2Hide){
                    circleProgressIndeterminate.hide()
                    isCircle2Hide = true
                    circleHide2.text = "Show"
                }
                else{
                    circleProgressIndeterminate.show()
                    isCircle2Hide = false
                    circleHide2.text = "Hide"
                }
            }
        }
    }
}