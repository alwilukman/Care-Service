package org.d3ifcool.careservice.ui.data.onsite.suzuki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentDaihatsuSiteBinding
import org.d3ifcool.careservice.databinding.FragmentMistubitshSiteBinding
import org.d3ifcool.careservice.databinding.FragmentSuzukiSiteBinding
import org.d3ifcool.careservice.firebase.mitsusite.MitsuSiteDb
import org.d3ifcool.careservice.firebase.suzukisite.SuzukiSiteDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteAdapter
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteFragmentDirections
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteViewModel
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteViewModelFactory

class SuzukiSiteFragment : Fragment() {

    private  lateinit var binding : FragmentSuzukiSiteBinding

    private val viewModel: SuzukiSiteViewModel by lazy {
        val db = SuzukiSiteDb.getInstance().dao
        val factory = SuzukiSiteViewModelFactory(db)
        ViewModelProvider(this, factory)[SuzukiSiteViewModel::class.java]
    }
    private lateinit var myAdapter: SuzukiSiteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuzukiSiteBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = SuzukiSiteAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(SuzukiSiteFragmentDirections.actionSuzukiSiteFragmentToTransaksiSiteFragment(item.nama))
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