package com.leon.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.leon.homework.R
import com.leon.homework.databinding.FragmentListInfoBinding
import com.leon.homework.ui.adapter.NewsAdapter
import com.leon.homework.ui.viewmodel.ListInfoViewModel
import com.leon.homework.ui.viewmodel.ViewModelFactory

class ListInfoFragment : Fragment() {

    private lateinit var viewModel: ListInfoViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =
            ViewModelProvider(
                this,
                ViewModelFactory()
            ).get(ListInfoViewModel::class.java)

        val binding = FragmentListInfoBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner

        newsAdapter = NewsAdapter()
        binding.listView.adapter = newsAdapter

        binding.toolbarInfoList.inflateMenu(R.menu.list_info_toolbar)
        binding.toolbarInfoList.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_timezone -> {
                    Navigation.findNavController(binding.root)
                        .navigate(R.id.action_list_info_to_update_users)
                    true
                }
                else -> false
            }
        }

        viewModel.news.observe(viewLifecycleOwner, Observer {
            val newsList = it ?: return@Observer
            newsAdapter.submitList(newsList)
        })

        return binding.root
    }
}