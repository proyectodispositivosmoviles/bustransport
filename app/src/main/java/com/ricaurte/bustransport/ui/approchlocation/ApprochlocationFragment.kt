package com.ricaurte.bustransport.ui.approchlocation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class ApprochlocationFragment : Fragment() {

    companion object {
        fun newInstance() = ApprochlocationFragment()
    }

    private lateinit var viewModel: ApprochlocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_approchlocation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApprochlocationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}