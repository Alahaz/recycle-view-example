package com.ziesapp.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listPahlawan: ArrayList<Pahlawan>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.baris_pahlawan, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPahlawan.size

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pahlawan = listPahlawan[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.foto)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = pahlawan.nama
        holder.tvDetail.text = pahlawan.detail
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_pahlawan)
        var tvDetail: TextView = itemView.findViewById(R.id.detail_pahlawan)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_foto_pahlawan)

    }
}