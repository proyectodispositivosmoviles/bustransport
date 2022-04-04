package com.ricaurte.bustransport.ui.approchlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentApprochlocationBinding
import com.ricaurte.bustransport.ui.reserve.ReserveViewModel

class ApprochlocationFragment : Fragment() {

    //private val  arg: ApprochlocationFragmentArgs by navArgs()

    private lateinit var approchlocationViewModel: ApprochlocationViewModel
    private lateinit var approchlocationBinding: FragmentApprochlocationBinding
    val options = GoogleMapOptions()
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
        googleMap.addMarker(
            MarkerOptions().position(terminaldelsur).title("Terminal del sur - Medellin")
                .snippet("Taquilla Sotrasabar")
        )

        val itagui = LatLng(6.1674364, -75.6076664)
        googleMap.addMarker(
            MarkerOptions().position(itagui).title("Itagui - Puente peatonal")
                .snippet("calle 50, Autopista sur")
                .icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
                )
        )

        val la_estrella = LatLng(6.153493, -75.630318)
        googleMap.addMarker(
            MarkerOptions().position(la_estrella).title("La estrella - Autopista sur")
                .snippet("79 sur 129, Autopista sur").icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                )
        )

        val ayura = LatLng(6.186369, -75.586663)
        googleMap.addMarker(
            MarkerOptions().position(ayura).title("Estación - Ayura")
                .snippet("Estacion metro Ayura - Autopista sur").icon(
                    BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
                )
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ayura))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ayura, 11.5F))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        approchlocationBinding = FragmentApprochlocationBinding.inflate(inflater, container, false)
        approchlocationViewModel = ViewModelProvider(this)[ApprochlocationViewModel::class.java]
        return approchlocationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(approchlocationBinding) {
            continueThreeButton.setOnClickListener {
                when {
                    approchlocationBinding.oneApproachRadioButton.isChecked -> {
                        findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToPsepayFragment())
                    }
                    approchlocationBinding.twoApproachRadioButton.isChecked -> {
                        findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToPsepayFragment())
                    }
                    approchlocationBinding.threeApproachRadioButton.isChecked -> {
                        findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToPsepayFragment())
                    }
                    approchlocationBinding.fourApproachRadioButton.isChecked -> {
                        findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToPsepayFragment())
                    }
                    else -> {
                        Toast.makeText(requireContext(), "Seleccione tu punto de abordaje", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        approchlocationBinding.returnOneButton.setOnClickListener {
            findNavController().navigate(ApprochlocationFragmentDirections.actionApprochlocationFragmentToReserveFragment())
        }
    }





}