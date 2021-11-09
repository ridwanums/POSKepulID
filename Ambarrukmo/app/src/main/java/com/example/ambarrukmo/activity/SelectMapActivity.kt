package com.example.ambarrukmo.activity

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.ambarrukmo.R
import com.example.ambarrukmo.databinding.ActivitySelectMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.tileprovider.TileStates
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import java.util.*

class SelectMapActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectMapBinding
    private lateinit var myLocationOverlay : MyLocationNewOverlay
    private var marker : Marker? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mapTileState: TileStates
    private lateinit var mapFirstController : IMapController


    var lat = "-7.782391424099107"
    var long = "110.40126925278564"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Configuration.getInstance().userAgentValue = packageName.toString()
        binding.mapView.setTileSource(TileSourceFactory.MAPNIK)
        binding.mapView.setMultiTouchControls(true)
        binding.mapView.zoomController.activate()
        binding.mapView.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
        myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this), binding.mapView)
        myLocationOverlay.enableMyLocation()
        binding.mapView.overlays.add(myLocationOverlay)
        mapTileState = binding.mapView.overlayManager.tilesOverlay.tileStates

        val mEventReceive : MapEventsReceiver = object : MapEventsReceiver {
            override fun singleTapConfirmedHelper(p: GeoPoint): Boolean {
                InfoWindow.closeAllInfoWindowsOn(binding.mapView)
                setMarker(p)
                return false
            }

            override fun longPressHelper(p: GeoPoint): Boolean {
                return false
            }

        }

        val overlayEvent = MapEventsOverlay(mEventReceive)
        binding.mapView.overlays.add(overlayEvent)
        mapFirstController = binding.mapView.controller
        mapFirstController.setZoom(17.0)
        mapFirstController.setCenter(
            GeoPoint(
                lat.trim().toDouble(), long.trim().toDouble()
            )
        )
        marker = Marker(binding.mapView)
        marker!!.position = GeoPoint(
            lat.trim().toDouble(), long.trim().toDouble()
        )
        marker!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_point_maps)
        marker!!.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        binding.mapView.overlays.add(marker)
        binding.mapView.invalidate()
        binding.textName.text = "Plaza Ambarukmo"
        binding.textTime.text = "10.00 s/d 22.00"
        binding.textAddress.text = "Jl. Laksda Adisucipto No.80, Ambarukmo, Caturtunggal, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55281"
    }

    private fun setMarker(p: GeoPoint) {
//        if (marker != null){
//            binding.mapView.overlays.remove(marker)
//            binding.mapView.invalidate()
//            marker = Marker(binding.mapView)
//            marker!!.position = p
//            marker!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_point_maps)
//            marker!!.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
//            binding.mapView.overlays.add(marker)
//            binding.mapView.invalidate()
//        }else {
//            marker = Marker(binding.mapView)
//            marker!!.position = p
//            marker!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_point_maps)
//            marker!!.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
//            binding.mapView.overlays.add(marker)
//            binding.mapView.invalidate()
//        }
//        val geocoder = Geocoder(this, Locale.getDefault())
//        val addresses: List<Address> =
//            geocoder.getFromLocation(p.latitude, p.longitude, 1)
//
//        var address = ""
//        if (addresses.isNotEmpty()) {
//            address =  addresses[0].getAddressLine(0)
//        }
//        val addressGeocoder = address
//        Log.e("TAG", "onItemSingleTapUp: lat"+p.latitude +" long "+p.longitude +"name "+addressGeocoder)
//        binding.textAddress.setText(address)
//        lat = p.latitude.toString()
//        long = p.longitude.toString()
    }
}