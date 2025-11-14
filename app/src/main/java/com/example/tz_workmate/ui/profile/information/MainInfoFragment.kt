package com.example.tz_workmate.ui.profile.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.R
import com.example.tz_workmate.databinding.FragmentMainInfoBinding
import com.example.tz_workmate.ui.utils.FragmentBinding

class MainInfoFragment : FragmentBinding<FragmentMainInfoBinding>() {


    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainInfoBinding.inflate(inflater, container, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_info, container, false)
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
        ) =
            MainInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}