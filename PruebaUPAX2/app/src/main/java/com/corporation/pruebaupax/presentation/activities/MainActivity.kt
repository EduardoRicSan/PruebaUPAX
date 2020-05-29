package com.corporation.pruebaupax.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.corporation.pruebaupax.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClicks()

    }

    /**
     * method to implement onClicks
     */
    private fun setOnClicks() {
        btMaps.setOnClickListener(this)
        btWS.setOnClickListener(this)
        btButton.setOnClickListener(this)
        btPersistence.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btMaps ->     startActivity(Intent(this@MainActivity, MapsActivity::class.java))
            R.id.btWS ->         startActivity(Intent(this@MainActivity, WebServiceActivity::class.java))
            R.id.btButton ->         startActivity(Intent(this@MainActivity, ButtonActivity::class.java))
            R.id.btPersistence ->         startActivity(Intent(this@MainActivity, PersistenceActivity::class.java))
        }
    }




}
