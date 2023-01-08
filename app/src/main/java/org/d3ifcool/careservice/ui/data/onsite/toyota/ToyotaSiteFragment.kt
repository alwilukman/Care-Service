package org.d3ifcool.careservice.ui.data.onsite.toyota

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentSuzukiSiteBinding
import org.d3ifcool.careservice.databinding.FragmentToyotaSiteBinding
import org.d3ifcool.careservice.firebase.suzukisite.SuzukiSiteDb
import org.d3ifcool.careservice.firebase.toyotasite.ToyotaSiteDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.onsite.suzuki.SuzukiSiteAdapter
import org.d3ifcool.careservice.ui.data.onsite.suzuki.SuzukiSiteFragmentDirections
import org.d3ifcool.careservice.ui.data.onsite.suzuki.SuzukiSiteViewModel
import org.d3ifcool.careservice.ui.data.onsite.suzuki.SuzukiSiteViewModelFactory

class ToyotaSiteFragment : Fragment() {

    private  lateinit var binding : FragmentToyotaSiteBinding

    private val viewModel: ToyotaSiteViewModel by lazy {
        val db = ToyotaSiteDb.getInstance().dao
        val factory = ToyotaSiteViewModelFactory(db)
        ViewModelProvider(this, factory)[ToyotaSiteViewModel::class.java]
    }
    private lateinit var myAdapter: ToyotaSiteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToyotaSiteBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = ToyotaSiteAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(ToyotaSiteFragmentDirections.actionToyotaSiteFragmentToTransaksiSiteFragment(item.nama))
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