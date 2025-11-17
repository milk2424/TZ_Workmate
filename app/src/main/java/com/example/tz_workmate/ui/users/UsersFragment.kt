package com.example.tz_workmate.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.user_generator.model.User
import com.example.tz_workmate.R
import com.example.tz_workmate.databinding.FragmentUsersBinding
import com.example.tz_workmate.presentation.users.UsersState
import com.example.tz_workmate.presentation.users.UsersViewModel
import com.example.tz_workmate.ui.users.delegates.userDelegate
import com.example.tz_workmate.ui.utils.FragmentBinding
import com.example.tz_workmate.ui.utils.UserDiffCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsersFragment : FragmentBinding<FragmentUsersBinding>() {

    private val viewModel: UsersViewModel by viewModel()

    private val delegationAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            UserDiffCallback, userDelegate(
                onItemClicked = { user ->
                    findNavController().navigate(
                        UsersFragmentDirections.actionUsersFragmentToProfileFragment(user)
                    )
                },
                onRemoveClicked = { user -> viewModel.removeUser(user) })
        )
    }


    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentUsersBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUsers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvUsers.adapter = delegationAdapter

        binding.btnGenerateNewUser.setOnClickListener {
            findNavController().navigate(R.id.action_usersFragment_to_userGeneratorFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                renderState(state)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadUsers()
    }

    private fun renderState(state: UsersState) {
        when (state) {
            is UsersState.Empty -> showEmpty()
            is UsersState.Loading -> showLoading()
            is UsersState.Success -> showData(state.users)
        }
    }

    private fun showData(data: List<User>) {
        delegationAdapter.items = data
        binding.rvUsers.visibility = VISIBLE
        binding.progressBar.visibility = GONE
        binding.tvError.visibility = GONE
    }

    private fun showLoading() {
        binding.rvUsers.visibility = GONE
        binding.progressBar.visibility = VISIBLE
        binding.tvError.visibility = GONE
    }

    private fun showEmpty() {
        binding.rvUsers.visibility = GONE
        binding.progressBar.visibility = GONE
        binding.tvError.visibility = VISIBLE
    }

    override fun onDestroyView() {
        binding.rvUsers.adapter = null
        super.onDestroyView()
    }

}