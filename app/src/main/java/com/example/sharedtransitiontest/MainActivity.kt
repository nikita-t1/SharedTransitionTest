package com.example.sharedtransitiontest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val navController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.FirstFragment){
            navController.popBackStack(R.id.FirstFragment, true)
            navController.popBackStack()
//            this.finish()
        }
        super.onBackPressed()

    }
}
