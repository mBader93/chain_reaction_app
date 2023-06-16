package com.example.chainreactionapp.feature.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chainreactionapp.databinding.RowItemsLayoutBinding
import com.example.chainreactionapp.feature.domain.model.ItemModel

class HomeAdapter(
    private val itemsList: List<ItemModel>, val onItemClick: (item: ItemModel) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    inner class ViewHolder(private val binding: RowItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.item = itemsList[position]
            itemView.setOnClickListener {
                onItemClick(itemsList[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowItemsLayoutBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}