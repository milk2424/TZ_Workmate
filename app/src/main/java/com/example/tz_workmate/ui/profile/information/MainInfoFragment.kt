package com.example.tz_workmate.ui.profile.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentMainInfoBinding
import com.example.tz_workmate.ui.utils.FragmentBinding

class MainInfoFragment : FragmentBinding<FragmentMainInfoBinding>() {


    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainInfoBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        arguments?.let {
            binding.tvFirstNameValue.text = it.getString(FIRST_NAME)
            binding.tvLastNameValue.text = it.getString(LAST_NAME)
            binding.tvGenderValue.text = it.getString(GENDER)
            binding.tvAgeValue.text = it.getLong(AGE).toString()
            binding.tvDateOfBirthValue.text = it.getString(DATE_OF_BIRTH)
        }
    }

    companion object {

        private const val FIRST_NAME = "first_name"
        private const val LAST_NAME = "last_name"
        private const val GENDER = "gender"
        private const val AGE = "age"
        private const val DATE_OF_BIRTH = "date_of_birth"

        fun newInstance(
            firstName: String,
            lastName: String,
            gender: String,
            age: Long,
            dateOfBirth: String
        ) = MainInfoFragment().apply {
            arguments = Bundle().apply {
                putString(FIRST_NAME, firstName)
                putString(LAST_NAME, lastName)
                putString(GENDER, gender)
                putLong(AGE, age)
                putString(DATE_OF_BIRTH, dateOfBirth)
            }
        }
    }
}