package com.example.omarsanchez.firstkotlin.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.omarsanchez.firstkotlin.R
import com.example.omarsanchez.firstkotlin.data.models.Day
import com.example.omarsanchez.firstkotlin.databinding.ItemBinding

/**
 * Created by omarsanchez on 6/8/17.
 */
class ForecastAdapter(var items: List<Day>) : RecyclerView.Adapter<ForecastAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        return Holder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.forecast = items[position]
        holder.binding.imageView.setImageResource(android.R.drawable.ic_menu_report_image)
        val url = holder.binding.root.context.getString(R.string.image_url, items[position].weather[0].icon)
        Glide.with(holder.binding.root.context).load(url).into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemBinding = DataBindingUtil.bind<ItemBinding>(itemView)
    }
}