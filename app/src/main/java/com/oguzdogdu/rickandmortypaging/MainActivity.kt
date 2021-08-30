package com.oguzdogdu.rickandmortypaging

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oguzdogdu.rickandmortypaging.adapter.RickMortyAdapter
import com.oguzdogdu.rickandmortypaging.databinding.ActivityMainBinding
import com.oguzdogdu.rickandmortypaging.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RickMortyAdapter
    private val viewModel : RickMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        loadData()
    }
    private fun loadData(){
    lifecycleScope.launch {
        viewModel.listData.collect { rick ->
            mAdapter.submitData(rick)

        }
    }

    }
    private fun setupRV(){
        mAdapter = RickMortyAdapter()

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = StaggeredGridLayoutManager(2
                , StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
        }
    }
}




