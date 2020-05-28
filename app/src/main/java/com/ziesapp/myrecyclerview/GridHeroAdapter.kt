package com.ziesapp.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(private val listPahlawan: ArrayList<Pahlawan>) :
    RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.grid_baris_pahlawan, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listPahlawan[position].foto)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener { onItemClickCallBack.onItemClicked(listPahlawan[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_foto_pahlawan)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pahlawan)
    }

}