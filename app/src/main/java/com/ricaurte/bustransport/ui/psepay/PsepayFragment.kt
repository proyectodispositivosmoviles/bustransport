package com.ricaurte.bustransport.ui.psepay

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.FragmentProfileBinding
import com.ricaurte.bustransport.databinding.FragmentPsepayBinding
import com.ricaurte.bustransport.ui.profile.ProfileFragmentDirections
import com.ricaurte.bustransport.ui.reserve.ReserveViewModel
import com.ricaurte.bustransport.ui.updatecount.UpdatecountFragmentDirections

class PsepayFragment : Fragment() {

    companion object {
        fun newInstance() = PsepayFragment()
    }

    private lateinit var psepayViewModel: PsepayViewModel
    private lateinit var psepayBinding: FragmentPsepayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        psepayBinding = FragmentPsepayBinding.inflate(inflater, container, false)
        psepayViewModel = ViewModelProvider(this)[PsepayViewModel::class.java]
        return psepayBinding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        psepayViewModel.loadDate()

        psepayBinding.returnOneButton.setOnClickListener {
            findNavController().navigate(PsepayFragmentDirections.actionPsepayFragmentToApprochlocationFragment())
        }

        psepayBinding.continueThreeButton.setOnClickListener {
                        findNavController().navigate(PsepayFragmentDirections.actionPsepayFragmentToPayconfirmationFragment())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        psepayViewModel = ViewModelProvider(this)[PsepayViewModel::class.java]
        // TODO: Use the ViewModel
    }

}