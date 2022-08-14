package com.example.amphibians.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.amphibians.databinding.FragmentAmphibianDetailBinding

/**
 * This Fragment shows the detailed information of the selected Amphibian.
 */
class AmphibianDetailFragment : Fragment() {

    // The 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact(provides extensions to various APIs)
    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAmphibianDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this  // determines the state of Fragment
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }
}
