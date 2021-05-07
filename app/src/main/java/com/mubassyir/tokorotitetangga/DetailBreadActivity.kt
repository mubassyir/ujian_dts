package com.mubassyir.tokorotitetangga


import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import com.mubassyir.tokorotitetangga.database.DatabaseBuilder
import com.mubassyir.tokorotitetangga.database.DatabaseHelperImpl
import com.mubassyir.tokorotitetangga.database.model.Ordered
import com.mubassyir.tokorotitetangga.databinding.ActivityDetailBreadBinding
import com.mubassyir.tokorotitetangga.model.BreadDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import pub.devrel.easypermissions.EasyPermissions

class DetailBreadActivity : AppCompatActivity() {
    private lateinit var property : BreadDataModel

    private var latitude: Double? = 0.0
    private var longtitude: Double? = 0.0

    private lateinit var binding: ActivityDetailBreadBinding

    companion object {
        const val EXTRA_BREAD = "extra_bread"
        private val RC_LOCATION_PERM = 124
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        onSupportNavigateUp()

         property = intent.getParcelableExtra<BreadDataModel>(EXTRA_BREAD) as BreadDataModel

        Glide.with(applicationContext).load(property.image)
            .into(binding.ivBreadImage)
        binding.ivBreadName.text = property.bakeName
        val price = "Rp.${property.price}"
        binding.ivBreadPrice.text = price

        binding.btnOrder.setOnClickListener {
            getMyCurrentLocation()
        }
    }

    private fun order(latitude:Double?, longtitude:Double?) {
        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        runBlocking {
            withContext(Dispatchers.IO){
                dbHelper.insert(Ordered(0,"user",property.bakeName,latitude.toString(),longtitude.toString(),property.price,property.image))
            }
        }
    }

    fun getMyCurrentLocation() {
        val mFusedLocation = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            EasyPermissions.requestPermissions(
                this, getString(R.string.rationale_location),
                RC_LOCATION_PERM,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            return
        }
        mFusedLocation.lastLocation.addOnSuccessListener(
            this,
            object : OnSuccessListener<Location> {
                override fun onSuccess(location: Location?) {
                    latitude = location?.latitude
                    longtitude = location?.longitude

                    Toast.makeText(
                        this@DetailBreadActivity,
                        "Lat : ${location?.latitude} Long : ${location?.longitude}",
                        Toast.LENGTH_LONG
                    ).show()

                    order(latitude, longtitude)
                }
            })

    }
}