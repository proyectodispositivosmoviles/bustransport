package com.ricaurte.bustransport.ui.approchlocation2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentApprochlocation2Binding
import com.ricaurte.bustransport.ui.reserve.ReserveFragmentDirections


class Approchlocation2Fragment : Fragment() {


    private lateinit var approchlocation2Binding: FragmentApprochlocation2Binding
    private lateinit var viewModel: Approchlocation2ViewModel

    private val callback = OnMapReadyCallback { googleMap ->

        val Santabarbara = LatLng(5.8735372, -75.5690521)
        googleMap.addMarker(
            MarkerOptions().position(Santabarbara).title("Santa Bárbara")
                .snippet("Terminal: Parque Principal")
        )

        val casablanca = LatLng(5.878338, -75.5699316)
        googleMap.addMarker(
            MarkerOptions().position(casablanca).title("Estadero ").snippet("Estadero Casa Blanca")
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
                )
        )

        val parador = LatLng(5.887469, -75.571577)
        googleMap.addMarker(
            MarkerOptions().position(parador).title("Via a Caldas").snippet("Parador la Antena")
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                )
        )

        val santa_caldas = LatLng(5.881941, -75.571442)
        googleMap.addMarker(
            MarkerOptions().position(santa_caldas).title("Carrera 50").snippet("Via hacia Caldas")
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                )
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(santa_caldas))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(santa_caldas, 14F))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        approchlocation2Binding =
            FragmentApprochlocation2Binding.inflate(inflater, container, false)
        return approchlocation2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        with(approchlocation2Binding) {
            continueFourButton.setOnClickListener {
                when {
                    approchlocation2Binding.oneApproachRadioButton.isChecked -> {
                        findNavController().navigate((Approchlocation2FragmentDirections.actionApprochlocation2FragmentToPsepayFragment4()))
                    }
                    approchlocation2Binding.twoApproachRadioButton.isChecked -> {
                        findNavController().navigate((Approchlocation2FragmentDirections.actionApprochlocation2FragmentToPsepayFragment4()))
                    }
                    approchlocation2Binding.threeApproachRadioButton.isChecked -> {
                        findNavController().navigate((Approchlocation2FragmentDirections.actionApprochlocation2FragmentToPsepayFragment4()))
                    }
                    approchlocation2Binding.fourApproachRadioButton.isChecked -> {
                        findNavController().navigate((Approchlocation2FragmentDirections.actionApprochlocation2FragmentToPsepayFragment4()))
                    }
                    else -> {
                        Toast.makeText(requireContext(), "Seleccione tu ruta", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        approchlocation2Binding.returnTwoButton.setOnClickListener {
            findNavController().navigate(Approchlocation2FragmentDirections.actionApprochlocation2FragmentToReserveFragment3())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[Approchlocation2ViewModel::class.java]
        // TODO: Use the ViewModel
    }

}