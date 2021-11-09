package com.example.ambarrukmo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ambarrukmo.databinding.ItemViewallBinding
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItemItem
import com.example.ambarrukmo.viewmodel.promo.result.*

class ViewAllAdater (val data : MerchantListItem) : RecyclerView.Adapter<ViewAllAdater.ViewHolder>(), Filterable {
    var filterable = MerchantListItem()
    init {
        filterable = data
    }
    inner class ViewHolder (val binding : ItemViewallBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fun bind(dataItem: MerchantListItem): Unit{

        }
        val dataItem : MerchantListItemItem = filterable[position]
        val context = holder.itemView.context
        holder.binding.textTitle.text = dataItem.merchant_name
        holder.binding.textSubtitle.text = dataItem.merchant_location_floor_txt
        Glide.with(context).load(dataItem.merchant_logo).into(holder.binding.imageLogo)

    }

    override fun getItemCount(): Int {
        return filterable.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()

                if (charSearch.isEmpty()){
                    filterable = data
                } else {
                    val resultList = MerchantListItem()
                    for (row in data){
                        if(row.merchant_name.lowercase().contains(charSearch.lowercase())){
                            resultList.add(row)
                        }
                    }
                    filterable = resultList
                }
                val filterResult = FilterResults()
                filterResult.values = filterable
                return filterResult
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterable = results?.values as MerchantListItem
                notifyDataSetChanged()
            }

        }
    }

}
