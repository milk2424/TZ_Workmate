package com.example.tz_workmate.ui.profile.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentEmailBinding
import com.example.tz_workmate.ui.utils.FragmentBinding


class EmailFragment : FragmentBinding<FragmentEmailBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentEmailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.tvEmailValue.text = it.getString(EMAIL)
            binding.tvUserNameValue.text = it.getString(USERNAME)
        }
    }

    companion object {

        private const val EMAIL = "email"
        private const val USERNAME = "username"

        fun newInstance(email: String, username: String) =
            EmailFragment().apply {
                arguments = Bundle().apply {
                    putString(EMAIL, email)
                    putString(USERNAME, username)
                }
            }
    }
}