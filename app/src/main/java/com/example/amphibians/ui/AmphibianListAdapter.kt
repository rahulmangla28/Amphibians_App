package com.example.amphibians.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amphibians.databinding.ListViewItemBinding
import com.example.amphibians.network.Amphibian

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class AmphibianListAdapter(val clickListener: AmphibianListener) :
    ListAdapter<Amphibian, AmphibianListAdapter.AmphibianViewHolder>(DiffCallback) {

    // A ViewHolder holds the item’s view.
    // It represents each item in our collection and used to display it.
    class AmphibianViewHolder(
        var binding: ListViewItemBinding
        ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: AmphibianListener, amphibian: Amphibian) {
            binding.amphibian = amphibian
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    // Check whether there is any change in the dataset.
    // Returns True if there is no change in the item of the dataset.
    companion object DiffCallback : DiffUtil.ItemCallback<Amphibian>() {

        override fun areItemsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.type == newItem.type && oldItem.description == newItem.description
        }

    }

    // Inflates the item layout and creates the [AmphibianViewHolder]
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmphibianViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AmphibianViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    // Updates the RecyclerView.ViewHolder contents with the item at the given position
    // and set the view attributes
    override fun onBindViewHolder(holder: AmphibianViewHolder, position: Int) {
        val amphibian = getItem(position)
        holder.bind(clickListener, amphibian)
    }
}

// Handles the onClick operation on the item of the List View
class AmphibianListener(val clickListener: (amphibian: Amphibian) -> Unit) {
    fun onClick(amphibian: Amphibian) = clickListener(amphibian)
}
