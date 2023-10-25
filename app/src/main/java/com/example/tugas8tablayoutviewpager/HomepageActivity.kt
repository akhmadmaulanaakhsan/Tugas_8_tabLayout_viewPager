package com.example.tugas8tablayoutviewpager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas8tablayoutviewpager.R
import com.example.tugas8tablayoutviewpager.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "MyTabLayout"
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                // Kembali ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Navigasi ke RegisterFragment dari MainActivity
                (this as MainActivity).navigateToRegister()
            }

            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

}
