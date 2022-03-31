package com.ricaurte.bustransport.ui.approchlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentApprochlocationBinding


class ApprochlocationFragment : Fragment() {

    private lateinit var viewModel: ApprochlocationViewModel
    private lateinit var approchlocationBinding: FragmentApprochlocationBinding

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val terminaldelsur = LatLng(6.2167754, -75.5888346)
        googleMap.addMarker(MarkerOptions().position(terminaldelsur).title("Terminal del sur").snippet("Sotrasabar"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(terminaldelsur))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminaldelsur, 17F))


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        approchlocationBinding = FragmentApprochlocationBinding.inflate(inflater, container, false)
        return approchlocationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        approchlocationBinding.continueThreeButton.setOnClickListener {
            findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToPsepayFragment())
        }

        approchlocationBinding.returnOneButton.setOnClickListener {
            findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToReserveFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApprochlocationViewModel::class.java)
        // TODO: Use the ViewModel
    }



}