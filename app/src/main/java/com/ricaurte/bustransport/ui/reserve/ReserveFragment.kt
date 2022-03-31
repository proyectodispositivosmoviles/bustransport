package com.ricaurte.bustransport.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ricaurte.bustransport.databinding.FragmentReserveBinding

class ReserveFragment : Fragment() {

    companion object {
        fun newInstance() = ReserveFragment()
    }

    private lateinit var viewModel: ReserveViewModel
    private lateinit var reserveFragment: FragmentReserveBinding
    private lateinit var reserveViewModel: ReserveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        reserveFragment = FragmentReserveBinding.inflate(inflater, container, false)
        return reserveFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(reserveFragment) {
            continueButton.setOnClickListener {
                if (reserveFragment.twoRouteRadioButton.isChecked) {
                    findNavController().navigate(ReserveFragmentDirections.actionReserveFragmentToApprochlocationFragment())
                }
                if (reserveFragment.oneRouteRadioButton.isChecked) {
                    findNavController().navigate(ReserveFragmentDirections.actionReserveFragmentToApprochlocation2Fragment())
                } else {
                    Toast.makeText(requireContext(), "Seleccione tu ruta", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReserveViewModel::class.java)
        // TODO: Use the ViewModel
    }
}