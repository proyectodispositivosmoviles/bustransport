package com.ricaurte.bustransport.ui.payconfirmation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentPayconfirmationBinding
import com.ricaurte.bustransport.ui.reserve.ReserveFragmentDirections

class PayconfirmationFragment : Fragment() {

    companion object {
        fun newInstance() = PayconfirmationFragment()
    }

    private lateinit var viewModel: PayconfirmationViewModel
    private lateinit var payconfirmationBinding: FragmentPayconfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        payconfirmationBinding = FragmentPayconfirmationBinding.inflate(inflater, container, false)
        return payconfirmationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        payconfirmationBinding.continuePayButton.setOnClickListener {
            findNavController().navigate(PayconfirmationFragmentDirections.actionPayconfirmationFragmentToCurrenttripFragment())
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PayconfirmationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}