package org.d3ifcool.careservice.ui.data.onsite.dai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentDaihatsuSiteBinding
import org.d3ifcool.careservice.databinding.FragmentMistubitshSiteBinding
import org.d3ifcool.careservice.firebase.daisite.DaiSiteDb
import org.d3ifcool.careservice.firebase.mitsusite.MitsuSiteDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteAdapter
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteFragmentDirections
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteViewModel
import org.d3ifcool.careservice.ui.data.onsite.mitsu.MitsubishiSiteViewModelFactory

class DaihatsuSiteFragment : Fragment() {

    private  lateinit var binding : FragmentDaihatsuSiteBinding

    private val viewModel: DaihatsuSiteViewModel by lazy {
        val db = DaiSiteDb.getInstance().dao
        val factory = DaihatsuSiteViewModelFactory(db)
        ViewModelProvider(this, factory)[DaihatsuSiteViewModel::class.java]
    }
    lateinit var myAdapter: DaihatsuSiteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaihatsuSiteBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = DaihatsuSiteAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(DaihatsuSiteFragmentDirections.actionDaihatsuSiteFragmentToTransaksiSiteFragment(item.nama))
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