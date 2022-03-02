package com.ricaurte.bustransport.ui.payconfirmation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class PayconfirmationFragment : Fragment() {

    companion object {
        fun newInstance() = PayconfirmationFragment()
    }

    private lateinit var viewModel: PayconfirmationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payconfirmation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PayconfirmationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}