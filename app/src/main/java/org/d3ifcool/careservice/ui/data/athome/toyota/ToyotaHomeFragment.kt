package org.d3ifcool.careservice.ui.data.athome.toyota

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentDaihatsuHomeBinding
import org.d3ifcool.careservice.databinding.FragmentMitsubishiHomeBinding
import org.d3ifcool.careservice.databinding.FragmentSuzukiHomeBinding
import org.d3ifcool.careservice.databinding.FragmentToyotaHomeBinding
import org.d3ifcool.careservice.firebase.suzukihome.SuzukiHomeDb
import org.d3ifcool.careservice.firebase.toyotahome.ToyotaHomeDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.athome.suzuki.SuzukiHomeAdapter
import org.d3ifcool.careservice.ui.data.athome.suzuki.SuzukiHomeFragmentDirections
import org.d3ifcool.careservice.ui.data.athome.suzuki.SuzukiHomeViewModel
import org.d3ifcool.careservice.ui.data.athome.suzuki.SuzukiHomeViewModelFactory

class ToyotaHomeFragment : Fragment() {

    private  lateinit var binding: FragmentToyotaHomeBinding

    private val viewModel: ToyotaHomeViewModel by lazy {
        val db = ToyotaHomeDb.getInstance().dao
        val factory = ToyotaHomeViewModelFactory(db)
        ViewModelProvider(this, factory)[ToyotaHomeViewModel::class.java]
    }
    private lateinit var myAdapter: ToyotaHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToyotaHomeBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = ToyotaHomeAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(ToyotaHomeFragmentDirections.actionToyotaHomeFragmentToTransaksi(item.nama))
        })
        with(binding.recyclerView){
            adapter = myAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
    }
}