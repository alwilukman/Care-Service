package org.d3ifcool.careservice.ui.sos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.databinding.FragmentSosBinding
import org.d3ifcool.careservice.firebase.SosDb.SosDb

class SosFragment : Fragment() {


    private  lateinit var binding: FragmentSosBinding

    private val viewModel: SosViewModel by lazy {
        val db = SosDb.getInstance().dao
        val factory = SosViewModelFactory(db)
        ViewModelProvider(this, factory)[SosViewModel::class.java]
    }
    private lateinit var myAdapter: SosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSosBinding.inflate(
            layoutInflater, container, false
        )


        myAdapter = SosAdapter()
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