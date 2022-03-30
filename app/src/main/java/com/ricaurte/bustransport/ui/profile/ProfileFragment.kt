package com.ricaurte.bustransport.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.databinding.FragmentProfileBinding
import com.ricaurte.bustransport.server.UserServer
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import com.ricaurte.bustransport.ui.login.LoginActivity


class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.findUserDone.observe(viewLifecycleOwner){result->onFindUserDoneSuscribe(result)}
        profileViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)}

        return profileBinding.root
        }

    private fun onFindUserDoneSuscribe(userServer: UserServer) {
      profileBinding.nameProfileTextView.text=userServer.email
        profileBinding.phoneProfileTextView.text=userServer.phone
        profileBinding.usernameProfileTextView2.text=userServer.name
        context?.let { it1 ->
            Glide.with(it1).load(userServer.urlAvatar
            )
                .into(profileBinding.avatarUserImageView)

        }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(profileBinding) {
            profileViewModel.searchUserInServer()
            profileBinding.changeAccountButton.setOnClickListener {
                findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToUpdatecountFragment())
           }
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




