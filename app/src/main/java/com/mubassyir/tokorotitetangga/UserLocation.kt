package com.mubassyir.tokorotitetangga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mubassyir.tokorotitetangga.database.model.Ordered

class UserLocation : AppCompatActivity(), OnMapReadyCallback {

    companion object{
        const val EXTRA_LOCATION = "extra_location"
    }

    private lateinit var mMap: GoogleMap
    private var latitude:Double?=0.0
    private var longtitude:Double?=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_location)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val property = intent.getParcelableExtra<Ordered>(EXTRA_LOCATION) as Ordered
        latitude = property.latitude?.toDouble()
        longtitude = property.longtitude?.toDouble()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val customerLocation = LatLng(latitude!!, longtitude!!)
        mMap.addMarker(MarkerOptions().position(customerLocation).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(customerLocation))
    }
}