package com.golnaz.store_app.dashboard.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.golnaz.store_app.R
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.golnaz.store_app.databinding.HeaderItemListBinding
import javax.inject.Inject

class HeaderAdapter @Inject constructor() : RecyclerView.Adapter<HeaderAdapter.HeaderHolder>() {
    private var items: MutableList<AppData> = mutableListOf()

    inner class HeaderHolder(private val binding: HeaderItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: AppData) {
            binding.appData = model
        }
    }

    private var inflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding: HeaderItemListBinding =
            DataBindingUtil.inflate(inflater!!, R.layout.header_item_list, parent, false)
        return HeaderHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = if (items.isEmpty()) 0 else items.size

    fun fillData(items: MutableList<AppData>) {
        this.items = items
        notifyDataSetChanged()
    }
}
