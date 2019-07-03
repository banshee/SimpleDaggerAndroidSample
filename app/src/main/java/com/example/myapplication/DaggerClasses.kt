package com.example.myapplication

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

class Shark
class Dolphin

@Module
class SharkModule {
    @Provides
    fun provideShark(): Shark = Shark()
}

@Module
abstract class MyActivityModule {
    @ContributesAndroidInjector
    abstract fun thisNameDoesntMatter(): MainActivity
}

@Component(modules = [MyActivityModule::class, AndroidSupportInjectionModule::class, SharkModule::class])
interface YourApplicationComponent {
    fun inject(application: MyApplication)

//    fun getAShark(): Shark
    fun getADolphin(): Dolphin

    @Component.Factory
    interface Factory {
        fun withDolphin(@BindsInstance dolphin: Dolphin): YourApplicationComponent
    }
}

