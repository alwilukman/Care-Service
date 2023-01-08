package org.d3ifcool.careservice.ui.data.athome.suzuki

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
import org.d3ifcool.careservice.firebase.mitsuhome.MitshuHomeDb
import org.d3ifcool.careservice.firebase.suzukihome.SuzukiHomeDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeAdapter
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeFragmentDirections
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeViewModel
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeViewModelFactory

class SuzukiHomeFragment : Fragment() {

    private  lateinit var binding: FragmentSuzukiHomeBinding

    private val viewModel: SuzukiHomeViewModel by lazy {
        val db = SuzukiHomeDb.getInstance().dao
        val factory = SuzukiHomeViewModelFactory(db)
        ViewModelProvider(this, factory)[SuzukiHomeViewModel::class.java]
    }
    private lateinit var myAdapter: SuzukiHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuzukiHomeBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = SuzukiHomeAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(SuzukiHomeFragmentDirections.actionSuzukiHomeFragmentToTransaksi(item.nama))
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