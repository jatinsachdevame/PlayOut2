package com.example.playout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        loadFragment(BlankFragment1())
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when {
                menuItem.itemId == R.id.item1 -> {
                    loadFragment(BlankFragment1())
                    return@setOnNavigationItemSelectedListener true
                }

                menuItem.itemId == R.id.item2 -> {
                    loadFragment(BlankFragment2())
                    return@setOnNavigationItemSelectedListener true
                }

                menuItem.itemId == R.id.item3 -> {
                    loadFragment(BlankFragment3())
                    return@setOnNavigationItemSelectedListener true
                }

                else -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}