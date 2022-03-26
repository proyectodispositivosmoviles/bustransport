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
        return profileBinding.root
        profileViewModel.findUserDone.observe(viewLifecycleOwner){result->onFindUserDoneSuscribe(result)}
        profileViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }
    }

    private fun onFindUserDoneSuscribe(userServer: UserServer) {
      profileBinding.nameProfileTextView.text=userServer.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(profileBinding) {
            profileViewModel.searchUserInServer()

            profileBinding.phoneProfileTextView.text = "123456"
            profileBinding.usernameProfileTextView2.text = "fernando"
            context?.let { it1 ->
                Glide.with(it1).load(
                    "https://firebasestorage.googleapis.com/v0/b/bustransport-d73af.appspot.com/o/useravatars%2Favatar1.webp?alt=media&token=495ac296-40ea-4349-9b64-0f45dc679a49"
                )
                    .into(profileBinding.avatarUserImageView)

            }


            // }

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




