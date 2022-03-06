package com.ricaurte.bustransport.ui.approchlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ricaurte.bustransport.databinding.FragmentApprochlocationBinding

class ApprochlocationFragment : Fragment() {

    companion object {
        fun newInstance() = ApprochlocationFragment()
    }

    private lateinit var viewModel: ApprochlocationViewModel
    private lateinit var approchlocationBinding: FragmentApprochlocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        approchlocationBinding = FragmentApprochlocationBinding.inflate(inflater, container, false)
        return approchlocationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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