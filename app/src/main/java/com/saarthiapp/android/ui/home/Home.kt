package com.saarthiapp.android.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentHomeBinding

class Home : Fragment(), OnMapReadyCallback {
    private lateinit var mGoogleMap: GoogleMap
    private lateinit var fragHomeBinding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return fragHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            (childFragmentManager.findFragmentById(R.id.homeVolunteerMapFrag) as SupportMapFragment).getMapAsync(this)
        }
    }

    private fun bitmapDescriptorFromVector(
        context: Context,
        vectorResId: Int
    ): BitmapDescriptor? {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onMapReady(mMap: GoogleMap?) {
        mGoogleMap = mMap!!
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.clear() //clear old markers
        val googlePlex = CameraPosition.builder()
            .target(LatLng(37.4219999, -122.0862462))
            .zoom(16f)
            .bearing(0f)
            .tilt(45f)
            .build()
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null)
        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.4219999, -122.0862462))
                .title("Spider Man")
                .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_our_work))
        )
        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.4629101, -122.2449094))
                .title("Iron Man")
                .snippet("His Talent : Plenty of money")
        )
        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(37.3092293, -122.1136845))
                .title("Captain America")
        )
    }
}
