package com.corporation.pruebaupax.usecases

import android.content.Context
import android.widget.Toast

interface ThreadPresenter {
    //Interface to show a toast on activity who called this
    val context: Context
    fun toast(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }
}