package org.d3ifcool.careservice.ui.data.athome.kia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentKiaHomeBinding
import org.d3ifcool.careservice.firebase.kiahome.KiaHomeDb


class KiaHomeFragment : Fragment() {

    private  lateinit var binding: FragmentKiaHomeBinding


    private val viewModel: KiaHomeViewModel by lazy {
        val db = KiaHomeDb.getInstance().dao
        val factory = KiaHomeViewModelFactory(db)
        ViewModelProvider(this, factory)[KiaHomeViewModel::class.java]
    }
    private lateinit var myAdapter: KiaHomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKiaHomeBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = KiaHomeAdapter(org.d3ifcool.careservice.ui.data.athome.kia.ItemListener { item ->
            view?.findNavController()?.navigate(KiaHomeFragmentDirections.actionKiaHomeFragmentToTransaksi(item.nama))

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