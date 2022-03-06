package com.ricaurte.bustransport.ui.triplist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class TriplistFragment : Fragment() {

    companion object {
        fun newInstance() = TriplistFragment()
    }

    private lateinit var viewModel: TriplistViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_triplist, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TriplistViewModel::class.java)
        // TODO: Use the ViewModel
    }

}