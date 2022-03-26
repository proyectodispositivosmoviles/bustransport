package com.ricaurte.bustransport.ui.updatecount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.databinding.FragmentUpdatecountBinding
import com.ricaurte.bustransport.ui.profile.ProfileViewModel

class UpdatecountFragment : Fragment() {
    private lateinit var auth:Firebase

    companion object {
        fun newInstance() = UpdatecountFragment()
    }

    private lateinit var updatecountViewModel: UpdatecountViewModel
    private lateinit var updatecountBinding: FragmentUpdatecountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        updatecountBinding = FragmentUpdatecountBinding.inflate(inflater, container, false)
        updatecountViewModel = ViewModelProvider(this)[UpdatecountViewModel::class.java]
        return updatecountBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updatecountBinding.returnUpdateButton.setOnClickListener {
            findNavController().navigate(UpdatecountFragmentDirections.actionUpdatecountFragmentToProfileFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updatecountViewModel = ViewModelProvider(this).get(UpdatecountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}