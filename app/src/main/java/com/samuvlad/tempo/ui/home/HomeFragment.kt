package com.samuvlad.tempo.ui.home

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.samuvlad.tempo.MainActivity
import com.samuvlad.tempo.common.PermissionRequester
import com.samuvlad.tempo.common.extensions.observe
import com.samuvlad.tempo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var componentActivity: ComponentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel
        _binding.lifecycleOwner = this

        observer()

        return _binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentActivity = activity as MainActivity
        getPermission()
    }

    private fun getPermission() {
        PermissionRequester(
            componentActivity, ACCESS_COARSE_LOCATION,
            onDenied = { Toast.makeText(context, "Permiso denegado", Toast.LENGTH_LONG).show() },
            onShowRationale = { Toast.makeText(context, "Rotaniole", Toast.LENGTH_LONG).show() }).runWithPermission {
            viewModel.getLocation()
        }


    }

    private fun observer() {
        viewModel.eventFlow.observe(viewLifecycleOwner) {

        }
    }
}