package com.corporation.pruebaupax.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.corporation.pruebaupax.R
import com.corporation.pruebaupax.usecases.ThreadPresenter
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity(), ThreadPresenter {
    override val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)



        val button_dynamic = Button(this)
        button_dynamic.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        button_dynamic.text = "Dynamic Button"
        clButton.addView(button_dynamic)

        button_dynamic.setOnClickListener{
            Handler().postDelayed({
                toast("El tiempo ha concluido")
            }, 10000)
        }

    }


}
