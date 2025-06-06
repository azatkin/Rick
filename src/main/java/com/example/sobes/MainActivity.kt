package com.example.sobes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.di.LocalAppComponent
import com.example.sobes.di.mainComponent
import com.example.sobes.presentation.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalAppComponent provides mainComponent()) {
                AppTheme {
                    Screen()
                }
            }
        }
    }
}
