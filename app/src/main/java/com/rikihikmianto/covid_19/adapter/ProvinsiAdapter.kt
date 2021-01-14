package com.rikihikmianto.covid_19.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikihikmianto.covid_19.databinding.ItemProvinsiBinding
import com.rikihikmianto.covid_19.model.ProvinsiResponse


class ProvinsiAdapter(private var list: ArrayList<ProvinsiResponse>): RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>() {

    inner class ProvinsiViewHolder(val itemProvinsiBinding: ItemProvinsiBinding): RecyclerView.ViewHolder(itemProvinsiBinding.root){

        fun bind(provinsi: ProvinsiResponse){
            with(itemView){
                itemProvinsiBinding.tvName.text = provinsi.attributes.provinsi
                itemProvinsiBinding.tvPositif.text = provinsi.attributes.positif.toString()
                itemProvinsiBinding.tvSembuh.text = provinsi.attributes.sembuh.toString()
                itemProvinsiBinding.tvMeninggal.text = provinsi.attributes.meninggal.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val binding = ItemProvinsiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProvinsiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}