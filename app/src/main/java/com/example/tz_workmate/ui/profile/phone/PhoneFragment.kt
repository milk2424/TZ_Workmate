package com.example.tz_workmate.ui.profile.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentPhoneBinding
import com.example.tz_workmate.ui.utils.FragmentBinding


class PhoneFragment : FragmentBinding<FragmentPhoneBinding>() {


    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentPhoneBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.tvPhoneValue.text = it.getString(PHONE)
            binding.tvCellValue.text = it.getString(CELL)
        }
    }


    companion object {

        private const val PHONE = "phone"
        private const val CELL = "cell"

        fun newInstance(phone: String, cell: String) =
            PhoneFragment().apply {
                arguments = Bundle().apply {
                    putString(PHONE, phone)
                    putString(CELL, cell)
                }
            }
    }
}