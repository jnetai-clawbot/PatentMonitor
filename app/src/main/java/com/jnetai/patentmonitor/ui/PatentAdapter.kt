package com.jnetai.patentmonitor.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnetai.patentmonitor.databinding.ItemMainBinding
import com.jnetai.patentmonitor.model.Patent

class PatentAdapter(private val onClick: (Patent) -> Unit) : RecyclerView.Adapter<PatentAdapter.VH>() {
    var items: List<Patent> = emptyList()
    inner class VH(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = items[pos]
        h.binding.titleText.text = item.title
        h.binding.subtitleText.text = item.patentNumber + " · " + item.status
        h.binding.root.setOnClickListener { onClick(item) }
    }
}