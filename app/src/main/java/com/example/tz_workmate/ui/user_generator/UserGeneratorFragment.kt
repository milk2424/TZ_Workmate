package com.example.tz_workmate.ui.user_generator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.local_data.model.Country
import com.example.domain.local_data.model.Gender
import com.example.domain.user_generator.model.User
import com.example.tz_workmate.R
import com.example.tz_workmate.databinding.FragmentUserGeneratorBinding
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Empty
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Loading
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.NetworkError
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.ServerError
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Success
import com.example.tz_workmate.presentation.user_generator.UserGeneratorViewModel
import com.example.tz_workmate.ui.user_generator.adapter.CountryAdapter
import com.example.tz_workmate.ui.user_generator.adapter.GenderAdapter
import com.example.tz_workmate.ui.utils.FragmentBinding
import kotlinx.coroutines.launch
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

        binding.btnGenerate.setOnClickListener {
            val selectedGender = binding.spinnerGender.selectedItem as Gender
            val selectedCountry = binding.spinnerNationality.selectedItem as Country
            viewModel.generateUser(
                selectedGender.gender.lowercase(),
                selectedCountry.code.lowercase()
            )
        }

        binding.btnErrorOk.setOnClickListener {
            showDefault()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                renderState(state)
            }
        }

    }

    private fun renderState(state: UserGeneratorState) {
        when (state) {
            is UserGeneratorState.Default -> showDefault()
            is Success -> openUserProfile(state.user)
            is NetworkError -> showNetworkError()
            is ServerError -> showServerError(state.message)
            is Empty -> showEmpty()
            is Loading -> showLoading()
        }
    }

    private fun showLoading() {
        binding.groupError.visibility = GONE
        binding.groupContent.visibility = GONE
        binding.progressBar.visibility = VISIBLE
    }

    private fun showEmpty() {
        binding.groupError.visibility = VISIBLE
        binding.groupContent.visibility = GONE
        binding.progressBar.visibility = GONE
        val errorMessage = requireContext().getString(R.string.nothing_found)
        binding.tvError.text = errorMessage
    }

    private fun showNetworkError() {
        binding.groupError.visibility = VISIBLE
        binding.groupContent.visibility = GONE
        binding.progressBar.visibility = GONE
        val errorMessage = requireContext().getString(R.string.check_your_internet_connection)
        binding.tvError.text = errorMessage
    }

    private fun showServerError(message: String) {
        binding.groupError.visibility = VISIBLE
        binding.groupContent.visibility = GONE
        binding.progressBar.visibility = GONE
    }

    private fun openUserProfile(user: User) {
        showDefault()
        findNavController().navigate(
            UserGeneratorFragmentDirections.actionUserGeneratorFragmentToProfileFragment(user)
        )
    }

    private fun showDefault() {
        binding.groupError.visibility = GONE
        binding.groupContent.visibility = VISIBLE
        binding.progressBar.visibility = GONE
    }

    override fun onDestroyView() {
        binding.spinnerNationality.adapter = null
        binding.spinnerGender.adapter = null
        super.onDestroyView()
    }
}