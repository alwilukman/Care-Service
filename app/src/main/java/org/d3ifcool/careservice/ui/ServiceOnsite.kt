package org.d3ifcool.careservice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3ifcool.careservice.R

import org.d3ifcool.careservice.databinding.ServiceOnsiteBinding


class ServiceOnsite : Fragment() {


    private  lateinit var binding: ServiceOnsiteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ServiceOnsiteBinding.inflate(
            layoutInflater, container, false
        )

        binding.btnMistsubitshi.setOnClickListener { view: View ->
            view
            findNavController().navigate(R.id.action_serviceOnsite_to_mitsubishiSiteFragment
            )
        }
        binding.btnSuzuki.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_serviceOnsite_to_suzukiSiteFragment
            )
        }
        binding.btnToyota.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_serviceOnsite_to_toyotaSiteFragment
            )
        }
        binding.btnDaihatsu.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_serviceOnsite_to_daihatsuSiteFragment
            )
        }


        return binding.root

    }
}