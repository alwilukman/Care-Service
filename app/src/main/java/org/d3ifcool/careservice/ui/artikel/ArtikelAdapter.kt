package org.d3ifcool.careservice.ui.artikel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelEntities
import org.d3ifcool.careservice.databinding.ItemArtikelBinding

class ItemListener(val clickListener: (artikel: ArtikelEntities) -> Unit) {
    fun onClick(artikel: ArtikelEntities) = clickListener(artikel)
}


class ArtikelAdapter (private val clickListener: ItemListener) : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {
    private val data = mutableListOf<ArtikelEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArtikelBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<ArtikelEntities>) {
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
        private val binding: ItemArtikelBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artikel: ArtikelEntities, clickListener: ItemListener) = with(binding) {

            binding.artikel1.text = "${artikel.judul}"
            binding.artikel.setOnClickListener { clickListener.onClick(artikel) }
            Glide.with(img.context)
                .load(artikel.url)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(img)
        }
    }
}