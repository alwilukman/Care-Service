package org.d3ifcool.careservice.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.d3ifcool.careservice.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 1
    }

    @SuppressLint("MissingPermission")
    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                this.applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(gMap: GoogleMap) {
        map = gMap
        enableMyLocation()
        gMap.isMyLocationEnabled
        val lokasi = LatLng(-6.920432082789247, 107.60370834146391)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 7f))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.map_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.daihatsu -> {
            val lokasi = LatLng(-6.916660193827724, 107.62760011409567)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.916660193827724, 107.62760011409567))
                    .title("Tunas Daihatsu Bandung Ahmad Yani")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 15f))

            val lokasi2 = LatLng(-6.921953741753508, 107.61545148221488)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.921953741753508, 107.61545148221488))
                    .title("Astra Daihatsu Asia Afrika Bandung")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 15f))

            val lokasi3 = LatLng(-6.904113797924487, 107.59770869989072)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.904113797924487, 107.59770869989072))
                    .title("Astra Daihatsu Bandung Pasirkaliki")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 15f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        R.id.mitsubisi -> {

            val lokasi = LatLng(-6.947935417028264, 107.59665669956274)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.947935417028264, 107.59665669956274))
                    .title("Mitsubishi Fuso")

            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 13f))
            map.maxZoomLevel

            val lokasi2 = LatLng(-6.917453882047423, 107.59840421595685)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.917453882047423, 107.59840421595685))
                    .title("Mitsubishi Mahligai Gardujati")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 13f))

            val lokasi3 = LatLng(-6.9166186193347965, 107.62741257848232)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.9166186193347965, 107.62741257848232))
                    .title("DEALER MITSUBISHI")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 13f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        R.id.toyota -> {
            val lokasi = LatLng(-6.931825106322614, 107.62639797353113)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.931825106322614, 107.62639797353113))
                    .title("Plaza Toyota Bandung")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 13f))
            map.maxZoomLevel

            val lokasi2 = LatLng(-6.9220188, 107.61523292872647)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.9220188, 107.61523292872647))
                    .title("Auto2000 Asia Afrika")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 13f))

            val lokasi3 = LatLng(-6.892127056540839, 107.58448885756226)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.892127056540839, 107.58448885756226))
                    .title("Auto2000 Pasteur")

            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 13f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        R.id.suzuki -> {
            val lokasi = LatLng(-6.888481238083846, 107.62498767968415)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.888481238083846, 107.62498767968415))
                    .title("Suzuki Drive Train 4x4 2")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 13f))


            val lokasi2 = LatLng(-6.948943607018829, 107.62961347678134)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.948943607018829, 107.62961347678134))
                    .title("Suzukinyabdg")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 13f))

            val lokasi3 = LatLng(-6.9443854687338895, 107.58640921778421)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.9443854687338895, 107.58640921778421))
                    .title("suzuki ignis bandung")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 13f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        R.id.kia -> {
            val lokasi = LatLng(-6.948625269294978,  107.62498767968415)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.948625269294978, 107.62498767968415))
                    .title("KIA Siloam Motor")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 13f))


            val lokasi2 = LatLng(-6.892424001795559, 107.58544966150632, )
            map.addMarker(
                MarkerOptions().position(LatLng(-6.892424001795559, 107.58544966150632, ))
                    .title(" KIA Pasteur")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 13f))

            val lokasi3 = LatLng(-6.950080820771943, 107.68689748754161,)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.950080820771943, 107.68689748754161, ))
                    .title("PJ Auto Service Bandung KIA HYUNDAI")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 13f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        R.id.towing -> {
            val lokasi = LatLng(-6.902446432708377, 107.6492867465386)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.902446432708377, 107.6492867465386))
                    .title("Jasa Towing/Derek 24 Jam Bandung (0812-2146-0135)")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 13f))


            val lokasi2 = LatLng(-6.9584170230399, 107.5964179333579)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.9584170230399, 107.5964179333579))
                    .title("DEREK TOWING BANDUNG 24 jam - BLACKJACK (0813-8390-8940)")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 13f))

            val lokasi3 = LatLng(-6.930513026779502, 107.57745231965617)
            map.addMarker(
                MarkerOptions().position(LatLng(-6.930513026779502, 107.57745231965617))
                    .title("Jasa derek/towing 24jam bandung (0821-2976-6878)")
            )
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 13f))

            val lokasid = LatLng(-6.917759, 107.615345)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasid, 12f))

            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResult: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult)
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResult.isNotEmpty() &&
                grantResult[0] == PackageManager.PERMISSION_GRANTED
            ) {
                enableMyLocation()
            }
        }
    }
}
