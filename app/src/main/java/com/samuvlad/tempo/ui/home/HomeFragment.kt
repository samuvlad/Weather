package com.samuvlad.tempo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.samuvlad.tempo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import com.samuvlad.tempo.common.extensions.formatDate



@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel
        _binding.lifecycleOwner = this

        return _binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}