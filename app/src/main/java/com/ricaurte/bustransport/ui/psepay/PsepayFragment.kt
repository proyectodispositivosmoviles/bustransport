package com.ricaurte.bustransport.ui.psepay

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class PsepayFragment : Fragment() {

    companion object {
        fun newInstance() = PsepayFragment()
    }

    private lateinit var viewModel: PsepayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_psepay, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PsepayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}