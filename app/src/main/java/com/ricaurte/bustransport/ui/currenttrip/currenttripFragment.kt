package com.ricaurte.bustransport.ui.currenttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.R

class CurrenttripFragment : Fragment() {

    companion object {
        fun newInstance() = CurrenttripFragment()
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
