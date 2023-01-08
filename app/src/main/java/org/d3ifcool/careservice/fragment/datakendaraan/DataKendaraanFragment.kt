package org.d3ifcool.careservice.fragment.datakendaraan

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentInputDataKendaraanBinding
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanDb
import org.d3ifcool.careservice.firebase.datakendaraan.DataKendaraanEntities


class DataKendaraanFragment : Fragment(R.layout.fragment_input_data_kendaraan) {


    private var _binding: FragmentInputDataKendaraanBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DataKendaraanViewModel by lazy {
        val db = DataKendaraanDb.getInstance().dao
        val factory = DataKendaraanViewModelFactory(db)
        ViewModelProvider(this, factory)[DataKendaraanViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInputDataKendaraanBinding.bind(view)

        val jeniskendaraan = resources.getStringArray(R.array.jeniskendaraan)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, jeniskendaraan)
        binding.jenisKendaraan.setAdapter(arrayAdapter)

        val tipe = resources.getStringArray(R.array.tipemobil)
        val arrayAdapter1 = ArrayAdapter(requireContext(),R.layout.dropdown_item, tipe)
        binding.txtTipemobil.setAdapter(arrayAdapter1)






        binding.btnSimpandatakendaraan.setOnClickListener {

            val inputjenis = binding.inputJeniskendaraan.editText?.text.toString().trim()
            val inputnomesin = binding.inputNomormesin.editText?.text.toString().trim()
            val inputnopol = binding.inputNopol.editText?.text.toString().trim()
            val inputtipemobil = binding.inputTipemobil.editText?.text.toString().trim()
            val inputkilometer = binding.inputKilometer.editText?.text.toString().trim()
            val inputstnk = binding.inputStnk.editText?.text.toString().trim()

            if (inputjenis.isEmpty()) {
                binding.inputJeniskendaraan.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputnomesin.isEmpty()) {
                binding.inputNomormesin.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputnopol.isEmpty()) {
                binding.inputNopol.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputtipemobil.isEmpty()) {
                binding.inputTipemobil.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputkilometer.isEmpty()) {
                binding.inputKilometer.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputstnk.isEmpty()) {
                binding.inputStnk.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }

            var builder = AlertDialog.Builder(context)
            builder.setTitle("Data Kendaraan ANda")
            builder.setMessage("Check Kembali Data Kendaraan Anda, Anda Sudah Yakin?")
            builder.setNegativeButton("No", { dialog: DialogInterface?, which: Int -> })
            builder.setPositiveButton("Ya") { dialog: DialogInterface?, whitc: Int ->

                val inputjenis = binding.inputJeniskendaraan.editText?.text.toString()
                val inputnomesin = binding.inputNomormesin.editText?.text.toString()
                val inputnopol = binding.inputNopol.editText?.text.toString()
                val inputtipemobil = binding.inputTipemobil.editText?.text.toString()
                val inputkilometer = binding.inputKilometer.editText?.text.toString()
                val inputstnk = binding.inputStnk.editText?.text.toString()


                val datakendaraan = DataKendaraanEntities(
                    jenis = inputjenis,
                    nomesin = inputnomesin,
                    nopol = inputnopol,
                    tipemobil = inputtipemobil,
                    kilometer = inputkilometer,
                    stnk = inputstnk,

                    )
                viewModel.simpanDatakendaraan(datakendaraan)
            }
            builder.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}