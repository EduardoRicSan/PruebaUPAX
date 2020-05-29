package com.corporation.pruebaupax.presentation.activities

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.corporation.pruebaupax.R
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), View.OnClickListener, OnMapReadyCallback {


    private var mMap: GoogleMap? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        supportActionBar!!.hide()
        btAddMarkers.setOnClickListener(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap

        //These coordinates represent the latitude and longitude of the Googleplex. 21.17, Longitud: -100.933
        val latitude = 21.17
        val longitude = -100.933
        val zoomLevel = 15f

        val homeLatLng = LatLng(latitude, longitude)
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
        mMap!!.addMarker(MarkerOptions().position(homeLatLng))

    }

    override fun onClick(p0: View?) {
        val id = p0!!.id
        when(id){
            R.id.btAddMarkers -> {
                val lengthMarkers = etMarkers.text.toString().toInt()
                if (lengthMarkers == 0){
                    Toast.makeText(this, "Por favor, ingresa otra cantidad", Toast.LENGTH_SHORT).show()
                }else{
                    for (x in 0 until lengthMarkers) {
                        setMarkers()
                    }
                    Toast.makeText(this, "Amplia el mapa para observar todos los markers", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }

    //Set markers dependes of input number
    private fun setMarkers() {
            val latitude = (21.17.toInt()..30).random()
            val longitude =  (-100.933.toInt()..-99.000.toInt()).random()
            val zoomLevel = 15f
            val homeLatLng = LatLng(latitude.toDouble(), longitude.toDouble())
            mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))

            mMap!!.addMarker(MarkerOptions().position(homeLatLng))
        }



}
