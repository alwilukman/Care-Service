package org.d3ifcool.careservice.fragment.transaksi


import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.TransaksiBinding
import org.d3ifcool.careservice.date.DatePickerFragment
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDb
import org.d3ifcool.careservice.firebase.transaksi.TransaksiEntities


class Transaksi : Fragment(R.layout.transaksi) {

    private var _binding: TransaksiBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TransaksiViewModel by lazy {
        val db = TransaksiDb.getInstance().dao
        val factory = TransaksiViewModelFactory(db)
        ViewModelProvider(this, factory)[TransaksiViewModel::class.java]
    }
    private val args: TransaksiArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = TransaksiBinding.bind(view)

        val jam = resources.getStringArray(R.array.jam)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item, jam)
        binding.inputjam.setAdapter(arrayAdapter)

        val paket = resources.getStringArray(R.array.paketservice)
        val arrayAdapter1 = ArrayAdapter(requireContext(),R.layout.dropdown_item, paket)
        binding.inputpaket.setAdapter(arrayAdapter1)


        binding.apply {
            btnSelectDate.setOnClickListener {
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        tvSelectedDate.text = date
                    }
                }

                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        }



        val inputManual = "Rumah"
        val inputnomor = "+6282113670412"


        binding.btnSimpan.setOnClickListener {

            val inputalamt = binding.inputAlamat.editText?.text.toString().trim()
            val inputjadwal = binding.inputJadwal.editText?.text.toString().trim()
            val inputjam = binding.inputJam.editText?.text.toString().trim()
            val inputpaket = binding.inputPaket.editText?.text.toString().trim()
            val inputkeluhan = binding.inputKeluhan.editText?.text.toString().trim()

            if (inputalamt.isEmpty()) {
                binding.inputAlamat.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputjam.isEmpty()) {
                binding.inputJam.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputpaket.isEmpty()) {
                binding.inputPaket.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputjadwal.isEmpty()) {
                binding.inputJadwal.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputkeluhan.isEmpty()) {
                binding.inputKeluhan.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }

            var builder = AlertDialog.Builder(context)
            builder.setTitle("At-Home")
            builder.setMessage("Booking At-Home Sekarang?")
            builder.setNegativeButton("No",{ dialog: DialogInterface?, which:Int->})
            builder.setPositiveButton("Ya") { dialog: DialogInterface?, whitc: Int ->

                val inputalamat = binding.inputAlamat.editText?.text.toString()
                val inputjadwal = binding.tvSelectedDate.text.toString()
                val inputjam = binding.inputJam.editText?.text.toString()
                val inputpaket = binding.inputPaket.editText?.text.toString()
                val inputkeluhan = binding.inputKeluhan.editText?.text.toString()

                val transaksi = TransaksiEntities(
                    dealer = args.dealer,
                    alamat = inputalamat,
                    jadwal = inputjadwal,
                    jam = inputjam,
                    paket = inputpaket,
                    keluhan = inputkeluhan,
                )

                viewModel.simpanTransaksi(transaksi)
                val url = "https://api.whatsapp.com/send?phone=$inputnomor" +
                        "&text= " +
                        "Jenis Booking : $inputManual\n" +
                        "Alamat : $inputalamat\n" +
                        "Tanggal: $inputjadwal\n" +
                        "Jam: $inputjam\n" +
                        "Paket: $inputpaket\n" +
                        "Keluhan: $inputkeluhan"



                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            builder.show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}