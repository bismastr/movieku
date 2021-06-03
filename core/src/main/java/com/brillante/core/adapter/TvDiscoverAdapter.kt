package com.brillante.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brillante.core.databinding.ItemMovieBinding
import com.brillante.core.domain.model.MovieDiscover


class TvDiscoverAdapter : RecyclerView.Adapter<com.brillante.core.adapter.viewholder.FilmViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private val dataList = ArrayList<MovieDiscover>()

    fun setData(data: ArrayList<MovieDiscover>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.brillante.core.adapter.viewholder.FilmViewHolder {
        return com.brillante.core.adapter.viewholder.FilmViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: com.brillante.core.adapter.viewholder.FilmViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieDiscover)
    }
}