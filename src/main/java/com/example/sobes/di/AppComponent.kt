package com.example.sobes.di

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.sobes.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun vmFactory() : AppModuleFactory


    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}

val LocalAppComponent = staticCompositionLocalOf<AppComponent> {
    error("AppComponent not provided")
}

private var component: AppComponent? = null

fun Activity.mainComponent(): AppComponent {
    if (component == null) {
        component = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
    return component!!
}