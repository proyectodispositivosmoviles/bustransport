package com.ricaurte.bustransport.ui.reserve

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class Reserve_Fragment : Fragment() {

    companion object {
        fun newInstance() = Reserve_Fragment()
    }

    private lateinit var viewModel: ReserveViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reserve, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReserveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}