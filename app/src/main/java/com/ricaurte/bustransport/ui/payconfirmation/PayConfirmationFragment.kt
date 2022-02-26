package com.ricaurte.bustransport.ui.payconfirmation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class PayConfirmationFragment : Fragment() {

    companion object {
        fun newInstance() = PayConfirmationFragment()
    }

    private lateinit var viewModel: PayConfirmationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pay_confirmation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PayConfirmationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}