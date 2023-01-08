package org.d3ifcool.careservice.fragment.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.careservice.databinding.ItemActivityBinding
import org.d3ifcool.careservice.firebase.transaksi.TransaksiEntities

class ItemListener(val clickListener: (transaksi: TransaksiEntities) -> Unit) {
    fun onClick(transaksi: TransaksiEntities) = clickListener(transaksi)
}

class ActivityAdapter(val clickListener: ItemListener): RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    private val data = mutableListOf<TransaksiEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<TransaksiEntities>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], clickListener)
    }

    inner class ViewHolder(
        private val binding: ItemActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(transaksi: TransaksiEntities, clickListener: ItemListener) = with(binding) {



            binding.dealer.text = transaksi.dealer
            binding.jenis.text = "Alamat : ${transaksi.alamat}"
            binding.jam.text = "Jam : ${transaksi.jam}"
            binding.jadwal.text = "Jadwal : ${transaksi.jadwal}"
            binding.paket.text = "Paket Anda : ${transaksi.paket}"
            binding.keluhan.text = "Keluhan : ${transaksi.keluhan}"

            val batal = "Batal"
            val berhasil = "Berhasil"

           binding.batal.setOnClickListener {
               val url = "$batal"
               //di tombol ini update data untuk di tampilkandi history
           }

            binding.berhasil.setOnClickListener {

            }
        }
    }
}