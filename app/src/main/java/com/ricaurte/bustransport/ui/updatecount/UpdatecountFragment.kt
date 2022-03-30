package com.ricaurte.bustransport.ui.updatecount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.databinding.FragmentUpdatecountBinding

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
        updatecountViewModel.dataValidated.observe(viewLifecycleOwner) { result ->
            onDataValidatedSubscribe(result)
    }
        updatecountViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }
        with(updatecountBinding) {
            // val agree=termsConditionsRadioButton.isChecked
            updateDataButton.setOnClickListener {
                val email = FirebaseAuth.getInstance().currentUser?.email.toString()
                updatecountViewModel.validatefiels(
                    email,
                    nameUpdateEditText.text.toString(),
                    phoneUpdateEditText.text.toString(),
                    passwordUpdateEditText.text.toString(),
                    repPasswordUpdateEditText.text.toString(),
                    //agree,
                )
            }
        }
    }
    private fun onDataValidatedSubscribe(result: Boolean) {

        with(updatecountBinding) {
            val email = FirebaseAuth.getInstance().currentUser?.email.toString()
                updatecountViewModel.updateUserInServer(
                nameUpdateEditText.text.toString(),
                phoneUpdateEditText.text.toString(),
                email,
                passwordUpdateEditText.text.toString(),
                repPasswordUpdateEditText.text.toString(),
                    )
                }
    }
    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()

    }

}