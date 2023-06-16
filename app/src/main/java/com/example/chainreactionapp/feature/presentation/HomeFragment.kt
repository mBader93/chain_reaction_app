package com.example.chainreactionapp.feature.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.chainreactionapp.R
import com.example.chainreactionapp.databinding.FragmentHomeBinding
import com.example.chainreactionapp.feature.domain.model.HomeModel
import com.example.chainreactionapp.feature.domain.model.ItemModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModelObserver()
    }

    private fun initViewModelObserver() {
        lifecycleScope.launch {
            viewModel.homeStateFlow.flowWithLifecycle(lifecycle)
                .collectLatest { it?.let { initHomeAdapter(it) } }
        }
        lifecycleScope.launch {
            viewModel.loadingStateFLow.flowWithLifecycle(lifecycle)
                .collectLatest { handleLoading(it) }
        }
        lifecycleScope.launch {
            viewModel.onErrorStateFlow.flowWithLifecycle(lifecycle).collectLatest {
                it?.let { showError(it) }
            }
        }
    }

    private fun initHomeAdapter(homeData: HomeModel) {
        homeAdapter = homeData.itemsList?.let {
            HomeAdapter(it) {
                shareTo(it)
            }
        }
        _binding.fragmentHomeItemsRecycleView.apply {
            adapter = homeAdapter
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        _binding.fragmentHomeProgress.isGone = !isLoading
    }

    private fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun shareTo(itemModel: ItemModel) {

        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, itemModel.name + "\n" + itemModel.price)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Share to"))

    }
}