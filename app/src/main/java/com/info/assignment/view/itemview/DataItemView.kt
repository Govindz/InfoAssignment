package com.info.assignment.view.itemview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.info.assignment.R

/* *
 *ViewHolder items for DataAdapter
 * */
class DataItemView(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    val tvTitle = itemView?.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = itemView?.findViewById<TextView>(R.id.tvDescription)
    val imageView = itemView?.findViewById<ImageView>(R.id.imageView)
}