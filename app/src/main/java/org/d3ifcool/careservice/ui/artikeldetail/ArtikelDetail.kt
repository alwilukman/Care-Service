package org.d3ifcool.careservice.ui.artikeldetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.*



class ArtikelDetail : Fragment() {

    private lateinit var binding: FragmentArtikelDetailBinding
    private val args: ArtikelDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtikelDetailBinding.inflate(
            layoutInflater, container, false
        )

        binding.isi.text = "${args.isi}"
        binding.judul.text = "${args.judul}"
        Glide.with(binding.imageView.context)
            .load(args.url)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(binding.imageView)
    return binding.root
    }
}
