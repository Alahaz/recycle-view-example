package com.ziesapp.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listPahlawan: ArrayList<Pahlawan>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_baris_pahlawan, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val pahlawan = listPahlawan[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.foto)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = pahlawan.nama
        holder.tvDetail.text = pahlawan.detail
        holder.btnFav.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Favorit " + listPahlawan[holder.adapterPosition].nama,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share " + listPahlawan[holder.adapterPosition].nama,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih "+listPahlawan[position].nama,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listPahlawan.size
    }


    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgPhoto: ImageView = itemView.findViewById(R.id.img_foto_pahlawan)
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_pahlawan)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail_pahlawan)
        var btnFav: Button = itemView.findViewById(R.id.btn_set_fav)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)

    }

}