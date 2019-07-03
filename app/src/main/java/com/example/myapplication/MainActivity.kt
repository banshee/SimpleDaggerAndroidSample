package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var myShark: Shark

    @Inject
    lateinit var dolphin: Dolphin

    @Inject
    lateinit var myActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);

        println("qqq dolphin ${object{}.javaClass.enclosingClass} ${object{}.javaClass.enclosingMethod!!.name}: ${dolphin}")
        println("qqq shark ${object{}.javaClass.enclosingClass} ${object{}.javaClass.enclosingMethod!!.name}: ${myShark}")

        super.onCreate(savedInstanceState)
    }
}
