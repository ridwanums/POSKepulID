package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ambarrukmo.databinding.ItemValetHistoryBinding
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItemItem

class ValetFragmentHistoryAdapter (val data : ValetHistoryItem) : RecyclerView.Adapter<ValetFragmentHistoryAdapter.ViewHolder>(){
    inner class ViewHolder(val binding : ItemValetHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemValetHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem : ValetHistoryItemItem = data[position]
        holder.binding.textItemBrand.text = dataItem.car_brand
        holder.binding.textItemDate.text = dataItem.parking_date_in
        holder.binding.textItemFlat.text = dataItem.no_pol
        holder.binding.textItemNumber.text = dataItem.vallet_number
        holder.binding.textItemStatus.text = dataItem.status_txt
        holder.binding.textItemTime.text = dataItem.time_limit
    }

    override fun getItemCount(): Int {
        return data.size
    }
}