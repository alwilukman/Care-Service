package org.d3ifcool.careservice.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseUser
import org.d3ifcool.careservice.MainActivity
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.ProfileBinding

class Profile : Fragment() {

    private lateinit var binding: ProfileBinding

    private val viewModel: ProfileViewModel by lazy { ViewModelProvider(this)[ProfileViewModel::class.java] }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.authState.observe(viewLifecycleOwner, { updateUI(it) })

        binding = ProfileBinding.inflate(
            layoutInflater, container, false
        )
        binding.btndatacar.setOnClickListener { view: View ->
            view
            findNavController().navigate(
                R.id.action_profile_to_dataMobilFragment
            )
        }
        binding.btnhistroy.setOnClickListener { view: View ->
            view
            findNavController().navigate(
                R.id.action_profile_to_historyFragment
            )
        }
        binding.btnlogout.setOnClickListener {

            var builder = AlertDialog.Builder(context)
            builder.setTitle("log-out?")
            builder.setMessage("Yakin Anda Log-out")
            builder.setNegativeButton("No",{dialog:DialogInterface?,which:Int->})
            builder.setPositiveButton("Ya",{dialog:DialogInterface?,whitc:Int->

                AuthUI.getInstance().signOut(requireContext())
                viewModel.authState.observe(viewLifecycleOwner, { updateUI(it) })
            })
            builder.show()
        }

        return binding.root

    }


    fun updateUI(user: FirebaseUser?) = with(binding) {
        if (user == null) {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        } else {
            binding.namaTextView.text = user?.displayName
            Glide.with(imageView.context).load(user?.photoUrl).into(imageView)

        }
    }
}