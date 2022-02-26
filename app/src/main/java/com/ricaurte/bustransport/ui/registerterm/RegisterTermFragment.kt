package com.ricaurte.bustransport.ui.registerterm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricaurte.bustransport.R

class RegisterTermFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterTermFragment()
    }

    private lateinit var viewModel: RegisterTermViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_term_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterTermViewModel::class.java)
        // TODO: Use the ViewModel
    }

}