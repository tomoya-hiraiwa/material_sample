package com.example.bottomappbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomappbar.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.apply {
            bottomAppBar.setNavigationOnClickListener {
                Toast.makeText(this@MainActivity, "Navigation Icon", Toast.LENGTH_SHORT)
                    .show()
            }
            bottomAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.mail -> {
                        Toast.makeText(this@MainActivity, "Mail", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.reload -> {
                        Toast.makeText(this@MainActivity, "Reload", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.dashBord -> {
                        Toast.makeText(this@MainActivity, "DashBord", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            fab.setOnClickListener {
                Toast.makeText(this@MainActivity, "FAB", Toast.LENGTH_SHORT).show()
            }
            hideSwitch.setOnCheckedChangeListener { _, isChecked ->
                bottomAppBar.hideOnScroll = isChecked
            }
            fabAlinSwitch.setOnCheckedChangeListener { _, isChecked ->
                bottomAppBar.fabAlignmentMode = if (isChecked) BottomAppBar.FAB_ALIGNMENT_MODE_END else BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
            fabAnimationSwitch.setOnCheckedChangeListener { _, isChecked ->
                bottomAppBar.fabAnimationMode = if (isChecked) BottomAppBar.FAB_ANIMATION_MODE_SCALE else BottomAppBar.FAB_ANIMATION_MODE_SLIDE
            }
            cradleMargin.apply {
                maxValue = 50
                minValue = 0
                value = 6
                setOnValueChangedListener { picker, oldVal, newVal ->
                    val dp = newVal * resources.displayMetrics.density
                    bottomAppBar.fabCradleMargin = dp
                }
            }
            cradleResetButton.setOnClickListener {
                cradleMargin.value = 6
                val dp = 6 * resources.displayMetrics.density
                bottomAppBar.fabCradleMargin = dp
            }
            cradleRound.apply {
                maxValue = 20
                minValue = 0
                value = 4
                setOnValueChangedListener { picker, oldVal, newVal ->
                    val dp = newVal * resources.displayMetrics.density
                    bottomAppBar.fabCradleRoundedCornerRadius = dp
                }
            }
            roundResetButton.setOnClickListener {
                cradleRound.value = 4
                val dp = 4 * resources.displayMetrics.density
                bottomAppBar.fabCradleRoundedCornerRadius = dp
            }
            cradleOffset.apply {
                maxValue = 50
                minValue = 0
                value = 12
                setOnValueChangedListener { picker, oldVal, newVal ->
                    val dp = newVal * resources.displayMetrics.density
                    bottomAppBar.cradleVerticalOffset = dp
                }
            }
            offsetResetButton.setOnClickListener {
                cradleOffset.value = 12
                val dp = 12 * resources.displayMetrics.density
                bottomAppBar.cradleVerticalOffset = dp
            }


        }
    }
}