package org.d3ifcool.careservice.ui.sos

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.withContext
import org.d3ifcool.careservice.MainActivity
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.ItemSosBinding
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelEntities
import org.d3ifcool.careservice.firebase.SosDb.SosEntities


class SosAdapter: RecyclerView.Adapter<SosAdapter.ViewHolder>() {
    private val data = mutableListOf<SosEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSosBinding.inflate(inflater, parent, false)



        return ViewHolder(binding)



        
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<SosEntities>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }




    inner class ViewHolder(
        private val binding: ItemSosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sos: SosEntities) = with(binding) {
            binding.nama.text = "${sos.nama}"

            binding.btnCall.setOnClickListener{
                val intent = Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + "${sos.no}"))
                itemView.context.startActivity(intent)
            }

            Glide.with(image.context)
                .load(sos.url)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(image)
        }

    }


}