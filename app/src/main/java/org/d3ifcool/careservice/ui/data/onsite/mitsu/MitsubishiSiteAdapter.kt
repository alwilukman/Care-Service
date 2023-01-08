package org.d3ifcool.careservice.ui.data.onsite.mitsu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.careservice.databinding.ItemDealerBinding
import org.d3ifcool.careservice.databinding.ItemDealerSiteBinding
import org.d3ifcool.careservice.firebase.dealer.DealerEntities
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener

class ItemListener(val clickListener: (dealer: DealerEntities) -> Unit) {
    fun onClick(dealer: DealerEntities) = clickListener(dealer)
}

class MitsubishiSiteAdapter (private val clickListener: ItemListener) : RecyclerView.Adapter<MitsubishiSiteAdapter.ViewHolder>() {
    private val data = mutableListOf<DealerEntities>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDealerSiteBinding.inflate(inflater, parent, false)
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
        private val binding: ItemDealerSiteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dealer: DealerEntities, clickListener: ItemListener) = with(binding) {

            binding.dealernamesite.text = dealer.nama
            binding.addresssite.text = "Alamat: ${dealer.address}"
            binding.emailsite.text = "Email: ${dealer.mail}"
            binding.phonesite.text = "Phone: ${dealer.phone}"
            binding.messagesite.text = "Message: ${dealer.message}"
            binding.operationalsite.text = "Jam Operasional: ${dealer.operational}"


            binding.btnBooksite.setOnClickListener { clickListener.onClick(dealer) }
        }
    }
}