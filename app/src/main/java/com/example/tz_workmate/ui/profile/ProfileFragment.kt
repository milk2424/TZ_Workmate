package com.example.tz_workmate.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.tz_workmate.databinding.FragmentProfileBinding
import com.example.tz_workmate.ui.profile.mapper.FullNameMapper
import com.example.tz_workmate.ui.utils.FragmentBinding


class ProfileFragment : FragmentBinding<FragmentProfileBinding>() {

    val args: ProfileFragmentArgs by navArgs()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentProfileBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = args.user

        Glide
            .with(requireContext())
            .load(user.img)
            .transform(CircleCrop())
            .into(binding.imgUser)

        binding.tvUserName.text = FullNameMapper.map(user.firstName, user.lastName)

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }

    }


}