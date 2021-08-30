package com.golnaz.store_app.dashboard.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.golnaz.store_app.R
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.golnaz.store_app.databinding.HeaderItemListBinding
import com.golnaz.store_app.databinding.MainItemListBinding
import javax.inject.Inject

class MainAdapter @Inject constructor(): RecyclerView.Adapter<MainAdapter.MainHolder>() {
     var items: MutableList<AppData> = mutableListOf()

    inner class MainHolder(private val binding: MainItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: AppData) {
            binding.appData = model
        }
    }

    private var inflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding: MainItemListBinding =
            DataBindingUtil.inflate(inflater!!, R.layout.main_item_list, parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = if (items.isEmpty()) 0 else items.size

    fun fillData(items: MutableList<AppData>) {
        this.items = items
        notifyDataSetChanged()
    }
}
