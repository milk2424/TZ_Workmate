package com.example.tz_workmate.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.tz_workmate.R
import com.example.tz_workmate.databinding.FragmentProfileBinding
import com.example.tz_workmate.ui.mapper.FullNameMapper
import com.example.tz_workmate.ui.profile.adapter.ProfileViewPagerAdapter
import com.example.tz_workmate.ui.utils.FragmentBinding
import com.google.android.material.tabs.TabLayoutMediator


class ProfileFragment : FragmentBinding<FragmentProfileBinding>() {

    val args: ProfileFragmentArgs by navArgs()

    private val viewPagerAdapter by lazy {
        ProfileViewPagerAdapter(
            childFragmentManager,
            lifecycle,
            args.user
        )
    }

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

        binding.vpProfile.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tlProfile, binding.vpProfile) { tab, position ->
            when (position) {
                MAIN_INFO_FRAGMENT_POSITION -> tab.setIcon(R.drawable.ic_profile)
                PHONE_FRAGMENT_POSITION -> tab.setIcon(R.drawable.ic_phone)
                EMAIL_FRAGMENT_POSITION -> tab.setIcon(R.drawable.ic_email)
                LOCATION_FRAGMENT_POSITION -> tab.setIcon(R.drawable.ic_location)
            }
        }.attach()

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        binding.vpProfile.adapter = null
        super.onDestroyView()
    }
    companion object {
        private const val MAIN_INFO_FRAGMENT_POSITION = 0
        private const val PHONE_FRAGMENT_POSITION = 1
        private const val EMAIL_FRAGMENT_POSITION = 2
        private const val LOCATION_FRAGMENT_POSITION = 3
    }

}