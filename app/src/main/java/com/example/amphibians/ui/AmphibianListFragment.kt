package com.example.amphibians.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.amphibians.R
import com.example.amphibians.databinding.FragmentAmphibianListBinding

/**
 * This Fragment shows the list of the Amphibians from the API.
 */
class AmphibianListFragment : Fragment() {

    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAmphibianListBinding.inflate(inflater)

        binding.lifecycleOwner = this    // Determines the state of Fragment LifeCycle.
        binding.viewModel = viewModel

        /** Binds the RecyclerView adapter to the AmphibianListAdapter and pass the object
         * amphibian to onAmphibianClicked.
         * Then it navigates from amphibianListFragment to amphibianDetailFragment. */
        binding.recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
            viewModel.onAmphibianClicked(amphibian)
            findNavController()
                .navigate(R.id.action_amphibianListFragment_to_amphibianDetailFragment)
        })

        // Inflate the layout for this fragment.
        return binding.root

    }
}
