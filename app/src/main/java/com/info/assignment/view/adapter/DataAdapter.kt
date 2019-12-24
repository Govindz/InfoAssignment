package com.info.assignment.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.info.assignment.R
import com.info.assignment.model.Data
import com.info.assignment.view.itemview.DataItemView
import java.util.*

/*
* Adapter class for display list of data rows in RecyclerView
* */
class DataAdapter(private val dataList: ArrayList<Data>) : RecyclerView.Adapter<DataItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataItemView {
        return DataItemView(
            LayoutInflater.from(parent.context).inflate(
                R.layout.data_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataItemView, position: Int) {
        val data: Data = dataList[position]
        //set title from data model
        holder.tvTitle?.text = data.title
        // Set description from data model
        holder.tvDescription?.text = data.description
        // Load images from url
        if (data.imageHref != null)
            Glide.with(holder.itemView.context)
                .load(data.imageHref)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_error)
                .into(holder.imageView!!)
        else
            holder.imageView?.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun notifyDataChanged(list: List<Data>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}