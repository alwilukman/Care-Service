package org.d3ifcool.careservice.fragment.transaksisite

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import org.d3ifcool.careservice.R
import org.d3ifcool.careservice.databinding.FragmentTransaksiSiteBinding
import org.d3ifcool.careservice.date.DatePickerFragment
import org.d3ifcool.careservice.firebase.transaksi.TransaksiDb
import org.d3ifcool.careservice.firebase.transaksi.TransaksiEntities


class TransaksiSiteFragment : Fragment(R.layout.fragment_transaksi_site) {

    private var _binding: FragmentTransaksiSiteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TransaksiSiteFragmentViewModel by lazy {
        val db = TransaksiDb.getInstance().dao
        val factory = TransaksiSiteFragmentViewModelFactory(db)
        ViewModelProvider(this, factory)[TransaksiSiteFragmentViewModel::class.java]
    }
    private val args: TransaksiSiteFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTransaksiSiteBinding.bind(view)

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
        val inputManual = "Dealer"
        var inputnomor = "+628987105187"


        binding.button.setOnClickListener {
            val inputnama = binding.inputNama.editText?.text.toString().trim()
            val inputnopol = binding.inputNopol.editText?.text.toString().trim()
            val inputjenis = binding.inputJeniskendaraan.editText?.text.toString().trim()
            val inputjadwal = binding.inputJadwal.editText?.text.toString().trim()
            val inputkeluhan = binding.inputKeluhan.editText?.text.toString().trim()

            if (inputnama.isEmpty()) {
                binding.inputNama.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputnopol.isEmpty()) {
                binding.inputNopol.error = "Data Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (inputjenis.isEmpty()) {
                binding.inputJeniskendaraan.error = "Data Tidak Boleh Kosong"
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
            builder.setTitle("On-Site")
            builder.setMessage("Booking On-Site Sekarang?")
            builder.setNegativeButton("No", { dialog: DialogInterface?, which: Int -> })
            builder.setPositiveButton("Ya") { dialog: DialogInterface?, whitc: Int ->


                val inputnama = binding.inputNama.editText?.text.toString()
                var inputnopol = binding.inputNopol.editText?.text.toString()
                var inputjenis = binding.inputJeniskendaraan.editText?.text.toString()
                var inputjadwal = binding.tvSelectedDate.text.toString()
                var inputkeluhan = binding.inputKeluhan.editText?.text.toString()



                val transaksi = TransaksiEntities(
                    dealer = args.dealer,
                    jam = inputnama,
                    paket = inputnopol,
                    alamat = inputjenis,
                    jadwal = inputjadwal,
                    keluhan = inputkeluhan,
                )

                viewModel.simpanTransaksiSite(transaksi)

                val url = "https://api.whatsapp.com/send?phone=$inputnomor" +
                        "&text= " +
                        "Jenis Booking : $inputManual\n" +
                        "Nama: $inputnama\n" +
                        "Nopol: $inputnopol\n" +
                        "Jenis Kendaraan Anda : $inputjenis\n" +
                        "Jadwal: $inputjadwal\n" +
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