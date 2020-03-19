package com.khusainov.rinat.pokedex.presentation.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khusainov.rinat.pokedex.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragment_container,
                    MainFragment.newInstance()
                )
                .commit()
        }

    }
}
