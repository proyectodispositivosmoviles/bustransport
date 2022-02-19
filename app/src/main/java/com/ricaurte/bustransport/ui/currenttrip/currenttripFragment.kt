package com.ricaurte.bustransport.ui.currenttrip

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class currenttripFragment : Fragment() {

    companion object {
        fun newInstance() = currenttripFragment()
    }

    private lateinit var viewModel: CurrenttripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currenttrip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrenttripViewModel::class.java)
        // TODO: Use the ViewModel
    }

}