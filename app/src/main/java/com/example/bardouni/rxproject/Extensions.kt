@file:JvmName("ExtensionsUtils")

package com.example.bardouni.rxproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



    fun ViewGroup.inflate(layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)

    }

