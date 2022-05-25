package com.leon.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.leon.homework.databinding.FragmentLoginBinding
import com.leon.homework.ui.viewmodel.AccountViewModel
import com.leon.homework.ui.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(
                requireActivity(),
                ViewModelFactory()
            ).get(AccountViewModel::class.java)

        val binding: FragmentLoginBinding =
            FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginResult
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect { result ->
                    if (result.isLoginSuccess) {
                        // TODO: Navigate to ListInfoFragment
                    } else {
                        Snackbar.make(binding.root, result.errorId, Snackbar.LENGTH_LONG).show()
                    }

                }
        }

        return binding.root
    }
}