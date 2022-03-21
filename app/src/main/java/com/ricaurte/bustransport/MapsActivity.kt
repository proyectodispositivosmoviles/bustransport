package com.ricaurte.bustransport

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ricaurte.bustransport.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val terminaldelsur = LatLng(6.2167754, -75.5888346)
        mMap.addMarker(MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador2))  .anchor(0.0f,1.0f)
            .position(terminaldelsur)
            .title("Terminal del sur")
            .snippet("Sotrasabar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(terminaldelsur))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminaldelsur, 17F))

        val Parquecaldas = LatLng(6.087429, -75.6450319)
        mMap.addMarker(MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador2))  .anchor(0.0f,1.0f)
            .position(Parquecaldas)
            .title("Caldas")
            .snippet("Parque de Caldas:"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Parquecaldas))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Parquecaldas, 14F))

        val Versalles = LatLng(5.9624484, -75.5891387)
        mMap.addMarker(MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador2))  .anchor(0.0f,1.0f)
            .position(Versalles)
            .title("Versalles")
            .snippet("Parrroquia San Roque de Versalles"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Versalles))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Versalles, 17F))


        val Santabarbara = LatLng(5.8735372, -75.5690521)
        mMap.addMarker(MarkerOptions()
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador2))  .anchor(0.0f,1.0f)
            .position(Santabarbara)
            .title("Santa Bárbara")
            .snippet("Terminal: Parque Principal de Santa Bárbara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Santabarbara))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Santabarbara, 17F))

    }
}