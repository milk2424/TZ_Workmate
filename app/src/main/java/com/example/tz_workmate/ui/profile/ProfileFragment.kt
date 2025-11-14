package com.example.tz_workmate.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentProfileBinding
import com.example.tz_workmate.ui.utils.FragmentBinding


class ProfileFragment : FragmentBinding<FragmentProfileBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentProfileBinding.inflate(inflater, container, false)


}