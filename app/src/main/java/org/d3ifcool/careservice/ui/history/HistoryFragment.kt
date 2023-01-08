package org.d3ifcool.careservice.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentActivityBinding
import org.d3ifcool.careservice.databinding.FragmentDataMobilBinding
import org.d3ifcool.careservice.databinding.FragmentHistoryBinding
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDb
import org.d3ifcool.careservice.fragment.activity.ActivityAdapter
import org.d3ifcool.careservice.fragment.activity.ActivityViewModel
import org.d3ifcool.careservice.fragment.activity.ActivityViewModelFactory
import org.d3ifcool.careservice.fragment.activity.ItemListener


class HistoryFragment : Fragment() {


    private val viewModel: ActivityViewModel by lazy {
        val db = TransaksiDb.getInstance().dao
        val factory = ActivityViewModelFactory(db)
        ViewModelProvider(this, factory)[ActivityViewModel::class.java]
    }
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var myAdapter: ActivityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        myAdapter = ActivityAdapter(ItemListener{
                item -> viewModel.deletebook(item.id)
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