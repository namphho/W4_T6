package com.watasolutions.w4_t6

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.watasolutions.w4_t6.model.Image

class NewImageAdapter : RecyclerView.Adapter<ImageViewHolder>(){
    var dataSet: ArrayList<Image> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        return ImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindData(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(data : List<Image>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

}