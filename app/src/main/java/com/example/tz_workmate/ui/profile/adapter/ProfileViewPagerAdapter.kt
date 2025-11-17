package com.example.tz_workmate.ui.profile.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.domain.user_generator.model.User
import com.example.tz_workmate.ui.mapper.StreetMapper
import com.example.tz_workmate.ui.profile.email.EmailFragment
import com.example.tz_workmate.ui.profile.information.MainInfoFragment
import com.example.tz_workmate.ui.profile.location.LocationFragment
import com.example.tz_workmate.ui.profile.phone.PhoneFragment

class ProfileViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var user: User
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun createFragment(position: Int) =
        when (position) {
            MAIN_INFO_FRAGMENT_POSITION -> MainInfoFragment.newInstance(
                user.firstName,
                user.lastName,
                user.gender,
                user.age,
                user.dateOfBirth
            )

            PHONE_FRAGMENT_POSITION -> PhoneFragment.newInstance(user.phone, user.cell)
            EMAIL_FRAGMENT_POSITION -> EmailFragment.newInstance(user.email, user.username)
            LOCATION_FRAGMENT_POSITION -> LocationFragment.newInstance(
                user.country, user.state, user.city, user.postcode,
                StreetMapper.map(user.streetName, user.streetNumber)
            )

            else -> {
                throw Throwable()
            }
        }


    override fun getItemCount(): Int {
        return FRAGMENTS_COUNT
    }

    companion object {
        private const val FRAGMENTS_COUNT = 4
        private const val MAIN_INFO_FRAGMENT_POSITION = 0
        private const val PHONE_FRAGMENT_POSITION = 1
        private const val EMAIL_FRAGMENT_POSITION = 2
        private const val LOCATION_FRAGMENT_POSITION = 3
    }
}