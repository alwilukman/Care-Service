package org.d3ifcool.careservice.ui.data.athome.mitsu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.careservice.databinding.ItemDealerBinding
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanEntities
import org.d3ifcool.careservice.firebase.dealer.DealerEntities

class ItemListener(val clickListener: (dealer: DealerEntities) -> Unit) {
    fun onClick(dealer: DealerEntities) = clickListener(dealer)
}

class MitsubishiHomeAdapter(private val clickListener: ItemListener) : RecyclerView.Adapter<MitsubishiHomeAdapter.ViewHolder>() {
    private val data = mutableListOf<DealerEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDealerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<DealerEntities>) {
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
        private val binding: ItemDealerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dealer: DealerEntities,  clickListener: ItemListener) = with(binding) {

            binding.dealername.text = dealer.nama
            binding.address.text = "Alamat: ${dealer.address}"
            binding.email.text = "Email: ${dealer.mail}"
            binding.phone.text = "Phone: ${dealer.phone}"
            binding.message.text = "Message: ${dealer.message}"
            binding.operational.text = "Jam Operasional: ${dealer.operational}"


            binding.btnBook.setOnClickListener { clickListener.onClick(dealer) }
        }
    }
}