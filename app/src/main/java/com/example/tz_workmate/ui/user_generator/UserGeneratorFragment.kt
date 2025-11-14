package com.example.tz_workmate.ui.user_generator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentUserGeneratorBinding
import com.example.tz_workmate.presentation.user_generator.UserGeneratorViewModel
import com.example.tz_workmate.ui.user_generator.adapter.CountryAdapter
import com.example.tz_workmate.ui.user_generator.adapter.GenderAdapter
import com.example.tz_workmate.ui.utils.FragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserGeneratorFragment : FragmentBinding<FragmentUserGeneratorBinding>() {

    private val viewModel: UserGeneratorViewModel by viewModel()

    private val countryAdapter by lazy {
        CountryAdapter(requireContext(), viewModel.loadCountries())
    }

    private val genderAdapter by lazy {
        GenderAdapter(requireContext(), viewModel.loadGenders())
    }

    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUserGeneratorBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinnerNationality.adapter = countryAdapter
        binding.spinnerGender.adapter = genderAdapter
    }

    override fun onDestroyView() {
        binding.spinnerNationality.adapter = null
        binding.spinnerGender.adapter = null
        super.onDestroyView()
    }
}