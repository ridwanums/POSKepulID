package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import co.id.codelabs.thesavia.utils.RecentUtils
import com.example.ambarrukmo.R
import com.example.ambarrukmo.databinding.ItemDropDownBinding
import com.example.ambarrukmo.viewmodel.content.result.ContentItem

class TermOfUseAdapter (val data : ContentItem, val detail : Boolean) : RecyclerView.Adapter<TermOfUseAdapter.ViewHolder>(){
    val initData = data.term_of_uses
    inner class ViewHolder (val binding : ItemDropDownBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                if (binding.layoutViewBottom.visibility == View.GONE){
                    binding.layoutViewBottom.visibility = View.VISIBLE
                    binding.imgAdd.setImageDrawable(ContextCompat.getDrawable(itemView.context,
                        R.drawable.ic_close))
                } else {
                    binding.layoutViewBottom.visibility = View.GONE
                    binding.imgAdd.setImageDrawable(ContextCompat.getDrawable(itemView.context,
                        R.drawable.ic_plus
                    ))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDropDownBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = initData[position]
        val desc = RecentUtils.fromHtml(dataItem.content)
        holder.binding.textTitle.text = dataItem.title
        holder.binding.textDesc.text = desc

        if(detail){
            holder.binding.imgAdd.visibility = View.GONE
            holder.binding.layoutViewBottom.visibility = View.VISIBLE
        } else {
            holder.binding.imgAdd.visibility = View.VISIBLE
            holder.binding.layoutViewBottom.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return initData.size
    }
}