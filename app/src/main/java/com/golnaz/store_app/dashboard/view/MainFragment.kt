package com.golnaz.store_app.dashboard.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.golnaz.store_app.dashboard.view.adapter.HeaderAdapter
import com.golnaz.store_app.dashboard.view.adapter.MainAdapter
import com.golnaz.store_app.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var headerAdapter: HeaderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initHeaderAdapter()
        getData()
        observeData()
    }

    private fun initHeaderAdapter() {
        headerAdapter = HeaderAdapter()
        binding.mostPopularList.layoutManager = layoutManager
        binding.mostPopularList.adapter = adapter

    }

    private fun initAdapter() {
        adapter = MainAdapter()
        binding.allAppList.layoutManager = layoutManager
        binding.allAppList.adapter = adapter
    }

    private fun getData() {
        viewModel.getData()
    }

    private fun observeData() {
        viewModel.allAppList.observe(requireActivity(), {
            adapter.fillData(it.toMutableList())
        })
        viewModel.mostPopularList.observe(requireActivity(), {
            headerAdapter.fillData(it.toMutableList())
        })
        viewModel.error.observe(requireActivity(), {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mostPopularList.adapter = null
        binding.allAppList.adapter = null
        _binding = null
    }


}