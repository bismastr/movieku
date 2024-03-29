package com.example.jetpack_submission1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brillante.core.databinding.ItemTrendingBinding
import com.brillante.core.domain.model.MovieDiscover
import com.example.jetpack_submission1.adapter.viewholder.TrendingViewHolder

class TrendingAdapter : RecyclerView.Adapter<TrendingViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private val dataList = ArrayList<MovieDiscover>()

    fun setData(movie: ArrayList<MovieDiscover>) {
        dataList.clear()
        dataList.addAll(movie)
        notifyDataSetChanged()
    }

    fun setOnItemCLickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(
            ItemTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClick(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickCallback {
        fun onItemClick(data: MovieDiscover)
    }
}