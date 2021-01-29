package com.aoinc.w5d4_customviews_animations.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import com.aoinc.w5d4_customviews_animations.R

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private val exampleFragment = ExampleFragment()
    private lateinit var frameLayout : FrameLayout

    private lateinit var menuView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.frame_layout)
        menuView = findViewById(R.id.menu_imageView)

        menuView.setOnClickListener{
            val popupMenu = PopupMenu(this, menuView)
            val inflater = popupMenu.menuInflater
            inflater.inflate(R.menu.main_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(this)
            popupMenu.show()
        }

//        supportFragmentManager.beginTransaction()
//            .setCustomAnimations(
//                R.anim.slide_in_from_bottom,
//                android.R.anim.slide_out_right,
//                android.R.anim.slide_in_left,
//                android.R.anim.slide_out_right)
//            .add(R.id.frame_layout, exampleFragment)
//            .addToBackStack(exampleFragment.tag)
//            .commit()
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        val message: String = when (item.itemId) {
            R.id.laundry_item -> "Laundry"
            R.id.gym_item -> "Gym"
            R.id.restaurant_item -> "Restaurant"
            else -> "Oops."
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        return true
    }
}