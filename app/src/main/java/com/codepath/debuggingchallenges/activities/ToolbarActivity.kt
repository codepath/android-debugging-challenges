package com.codepath.debuggingchallenges.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codepath.debuggingchallenges.R
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        // Find the toolbar view inside the activity layout
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar)
        val tvDescription = findViewById<View>(R.id.tvDescription) as TextView
        tvDescription.setText(R.string.hello)
    }
}