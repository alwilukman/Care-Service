package org.d3ifcool.careservice.ui.artikel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import org.d3ifcool.careservice.databinding.FragmentArtikelBinding
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelDb

class ArtikelFragment : Fragment() {


    private  lateinit var binding: FragmentArtikelBinding

    private val viewModel: ArtikelViewModel by lazy {
        val db = ArtikelDb.getInstance().dao
        val factory = ArtikelViewModelFactory(db)
        ViewModelProvider(this, factory)[ArtikelViewModel::class.java]
    }
    private lateinit var myAdapter: ArtikelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtikelBinding.inflate(
            layoutInflater, container, false
        )
        myAdapter = ArtikelAdapter(ItemListener { item ->
            view?.findNavController()?.navigate(ArtikelFragmentDirections.actionArtikelFragmentToArtikelDetail(item.url, item.judul, item.isi))
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