package org.d3ifcool.careservice.ui.data.athome.dai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentDaihatsuHomeBinding
import org.d3ifcool.careservice.firebase.daihome.DaiHomeDb
import org.d3ifcool.careservice.ui.data.athome.mitsu.ItemListener
import org.d3ifcool.careservice.ui.data.athome.mitsu.MitsubishiHomeAdapter


class DaihatsuHomeFragment : Fragment() {


    private  lateinit var binding: FragmentDaihatsuHomeBinding

    private val viewModel: DaihatsuHomeViewModel by lazy {
        val db = DaiHomeDb.getInstance().dao
        val factory = DaihatsuHomeViewModelFactory(db)
        ViewModelProvider(this, factory)[DaihatsuHomeViewModel::class.java]
    }
    private lateinit var myAdapter: MitsubishiHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaihatsuHomeBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = MitsubishiHomeAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(DaihatsuHomeFragmentDirections.actionDaihatsuHomeFragmentToTransaksi(item.nama))
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