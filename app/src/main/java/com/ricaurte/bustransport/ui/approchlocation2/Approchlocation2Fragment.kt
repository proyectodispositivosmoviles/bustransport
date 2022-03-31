package com.ricaurte.bustransport.ui.approchlocation2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentApprochlocation2Binding


class Approchlocation2Fragment : Fragment() {


    private lateinit var approchlocation2Binding: FragmentApprochlocation2Binding
    private lateinit var viewModel: Approchlocation2ViewModel

    private val callback = OnMapReadyCallback { googleMap ->

        val Santabarbara = LatLng(5.8735372, -75.5690521)
        googleMap.addMarker(MarkerOptions().position(Santabarbara).title("Santa Bárbara").snippet("Terminal: Parque Principal de Santa Bárbara"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Santabarbara))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Santabarbara,16F))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        approchlocation2Binding = FragmentApprochlocation2Binding.inflate(inflater,container, false)
        return approchlocation2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        approchlocation2Binding.continueFourButton.setOnClickListener{
            findNavController().navigate(Approchlocation2FragmentDirections.actionApprochlocation2FragmentToPsepayFragment4())
    }
        approchlocation2Binding.returnTwoButton.setOnClickListener{
            findNavController().navigate(Approchlocation2FragmentDirections.actionApprochlocation2FragmentToReserveFragment3())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[Approchlocation2ViewModel::class.java]
        // TODO: Use the ViewModel
    }

}