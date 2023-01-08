package org.d3ifcool.careservice.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentMenuUtamaBinding

class MenuUtamaFragment : Fragment() {

    private lateinit var binding: FragmentMenuUtamaBinding

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_menuUtamaFragment_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenuUtamaBinding.inflate(layoutInflater, container, false
        )

        binding.btnServicesite.setOnClickListener {

            var builder = AlertDialog.Builder(context)
            builder.setTitle("Masih Dalam Pengembangan")
            builder.setMessage("Maaf Menu Onsite ini Sedang Dalam Pengembangan")
            builder.setNegativeButton("ya",{ dialog: DialogInterface?, which:Int->})
                builder.show()

        }
        binding.btnServicehome.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_menuUtamaFragment_to_serviceAthome
            )
        }
        binding.btnartikel.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_menuUtamaFragment_to_artikelFragment
            )
        }
        binding.btnSos.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_menuUtamaFragment_to_sosFragment
            )
        }

        setHasOptionsMenu(true)
        return binding.root

    }
}