package com.leon.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.leon.homework.databinding.FragmentLoginBinding
import com.leon.homework.ui.viewmodel.AccountViewModel
import com.leon.homework.ui.viewmodel.ViewModelFactory

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

        return binding.root
    }
}