package com.example.myapplication

import android.app.Application
import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MyApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var myShark: Shark

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        val component = DaggerYourApplicationComponent.factory().withDolphin(Dolphin())
        component.inject(this)
        println("qqq injected: $dispatchingAndroidInjector $myShark")
        println("qqq dolphin ${object {}.javaClass.enclosingClass} ${object {}.javaClass.enclosingMethod!!.name}: ${component.getADolphin()}")
        println("qqq shark ${object {}.javaClass.enclosingClass} ${object {}.javaClass.enclosingMethod!!.name}: ${myShark}")
    }
}