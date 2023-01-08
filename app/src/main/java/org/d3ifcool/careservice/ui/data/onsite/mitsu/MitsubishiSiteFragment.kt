package org.d3ifcool.careservice.ui.data.onsite.mitsu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentMistubitshSiteBinding
import org.d3ifcool.careservice.firebase.mitsuhome.MitshuHomeDb
import org.d3ifcool.careservice.firebase.mitsusite.MitsuSiteDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeViewModel
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeViewModelFactory

class MitsubishiSiteFragment : Fragment() {

    private  lateinit var binding : FragmentMistubitshSiteBinding

    private val viewModel: MitsubishiSiteViewModel by lazy {
        val db = MitsuSiteDb.getInstance().dao
        val factory = MitsubishiSiteViewModelFactory(db)
        ViewModelProvider(this, factory)[MitsubishiSiteViewModel::class.java]
    }
    private lateinit var myAdapter: MitsubishiSiteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMistubitshSiteBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = MitsubishiSiteAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(MitsubishiSiteFragmentDirections.actionMitsubishiSiteFragmentToTransaksiSiteFragment(item.nama))
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