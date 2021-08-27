package com.codepath.debuggingchallenges.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepath.debuggingchallenges.R
import android.content.Intent
import android.view.View
import com.codepath.debuggingchallenges.activities.CurrentDayActivity
import com.codepath.debuggingchallenges.activities.MoviesActivity
import com.codepath.debuggingchallenges.activities.ChangeBackgroundActivity
import com.codepath.debuggingchallenges.activities.ToolbarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun launchActivity(klass: Class<*>) {
        val intent = Intent(this, klass)
        startActivity(intent)
    }

    fun launchCurrentDayActivity(view: View?) {
        launchActivity(CurrentDayActivity::class.java)
    }

    fun launchMoviesActivity(view: View?) {
        launchActivity(MoviesActivity::class.java)
    }

    fun launchChangeBackgroundActivity(view: View?) {
        launchActivity(ChangeBackgroundActivity::class.java)
    }

    fun launchToolbarActivity(view: View?) {
        launchActivity(ToolbarActivity::class.java)
    }
}