package com.oguzdogdu.rickandmortypaging.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oguzdogdu.rickandmortypaging.adapter.RickMortyAdapter
import com.oguzdogdu.rickandmortypaging.databinding.FragmentMainBinding
import com.oguzdogdu.rickandmortypaging.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private lateinit var mAdapter: RickMortyAdapter

    private val viewModel: RickMortyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        loadData()

    }
    private fun loadData() {
        lifecycleScope.launch {
            viewModel.getFileStream().collectLatest { rick ->
                mAdapter.submitData(rick)
            }
            /*
            viewModel.listData.collect { rick ->
                mAdapter.submitData(rick)
            }

             */
        }
    }

    private fun setupRV() {
        mAdapter = RickMortyAdapter()

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}