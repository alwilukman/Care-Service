package org.d3ifcool.careservice.fragment.datamobil

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.ItemMobilBinding
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanEntities

class ItemListener(val clickListener: (datakendaraan: DataKendaraanEntities) -> Unit) {
    fun onClick(datakendaraan: DataKendaraanEntities) = clickListener(datakendaraan)
}

class DataMobilAdapter(val clickListener: ItemListener): RecyclerView.Adapter<DataMobilAdapter.ViewHolder>() {

    private val data = mutableListOf<DataKendaraanEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMobilBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<DataKendaraanEntities>) {
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
        private val binding: ItemMobilBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(datakendaraan: DataKendaraanEntities, clickListener: ItemListener) = with(binding) {


            binding.tipeMobil.text = datakendaraan.tipemobil
            binding.jenisKendaraan.text = "Tipe Mobil : ${datakendaraan.jenis}"
            binding.nomorPolisi.text = "Nomor Polisi : ${datakendaraan.nopol}"
            binding.nomorMesin.text = "Nomor Mesin : ${datakendaraan.nomesin}"
            binding.kilometer.text = "Kilometer : ${datakendaraan.kilometer}"
            binding.stnk.text = "Masa Berlaku STNK : ${datakendaraan.stnk}"

            binding.hapus.setOnClickListener { clickListener.onClick(datakendaraan) }

            binding.btnGodealer.setOnClickListener { view: View ->
                view.findNavController().navigate(
                    R.id.action_dataMobilFragment_to_kiaHomeFragment
                )
            }


        }
    }
}