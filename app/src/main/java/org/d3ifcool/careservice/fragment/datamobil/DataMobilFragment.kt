package org.d3ifcool.careservice.fragment.datamobil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentDataMobilBinding
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDb


class DataMobilFragment : Fragment() {

    private lateinit var binding: FragmentDataMobilBinding

    private val viewModel: DataMobilViewModel by lazy {
        val db = DataKendaraanDb.getInstance().dao
        val factory = DataMobilViewModelFactory(db)
        ViewModelProvider(this, factory)[DataMobilViewModel::class.java]
    }
    private lateinit var myAdapter: DataMobilAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataMobilBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = DataMobilAdapter(org.d3ifcool.careservice.fragment.datamobil.ItemListener{
                item -> viewModel.deletebook(item.id)
        })
        with(binding.recyclerView){
            adapter = myAdapter
            setHasFixedSize(true)
        }

        binding.btnTambahDataKendaraan.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_dataMobilFragment_to_dataKendaraanFragment
            )
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