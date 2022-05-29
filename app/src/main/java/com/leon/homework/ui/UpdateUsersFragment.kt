package com.leon.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.leon.homework.R
import com.leon.homework.databinding.FragmentUpdateUsersBinding

class UpdateUsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateUsersBinding.inflate(layoutInflater, container, false)

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_update_users_to_list_info)
        }
        return binding.root
    }
}