package com.saarthiapp.android.ui.home

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentHomeBinding
import com.saarthiapp.android.ui.home.geofenceServices.GeofenceTransitionServices
import com.saarthiapp.android.ui.utils.createDrawableFromView

class Home : Fragment(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, LocationListener,
    GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener,
    ResultCallback<Status>, View.OnClickListener {

    private lateinit var mGoogleMap: GoogleMap
    private lateinit var fragHomeBinding:FragmentHomeBinding
    private lateinit var mGoogleApiClient:GoogleApiClient
    private lateinit var locationRequest:LocationRequest
    private lateinit var navController:NavController

    companion object{
        const val MY_PERMISSIONS_REQUEST_FINE_LOCATION = 111
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return fragHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        activity?.let {
            (childFragmentManager.findFragmentById(R.id.homeVolunteerMapFrag) as SupportMapFragment).getMapAsync(this)
        }

        fragHomeBinding.clSearchVolunteerLayout.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            fragHomeBinding.clSearchVolunteerLayout -> {
                navController.navigate(R.id.action_saarthiHome_to_searchVolunteerFrag)
            }
        }
    }






    override fun onMapReady(mMap: GoogleMap?) {
        mGoogleMap = mMap!!
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        //
        mGoogleMap.setOnMapClickListener(this)
        mGoogleMap.setOnMarkerClickListener(this)

        //
        mGoogleApiClient = GoogleApiClient.Builder(requireContext())
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build()
        mGoogleApiClient.connect()
/*
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
        )*/
    }

    private fun setupRecyclerView(){
        val layoutManagerVolunteer = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        fragHomeBinding.recViewHomeVolunteer.apply {
            layoutManager = layoutManagerVolunteer
            itemAnimator = DefaultItemAnimator()
            hasFixedSize()
        }
    }

    override fun onConnected(p0: Bundle?) {
        // Check for permission
        if (ContextCompat.checkSelfPermission(requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                requireActivity(), // Activity
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        }else{
            locationRequest = LocationRequest.create()
            locationRequest.apply {
                interval = 10000
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this)
        }
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    private var mMarker:Marker ?= null
    override fun onLocationChanged(location: Location?) {
        if(location != null){
            val latLng = LatLng(location.latitude, location.longitude)
            val mCamera = CameraUpdateFactory.newLatLngZoom(latLng, 14f)
            mGoogleMap.animateCamera(mCamera)





            val markerOptions = MarkerOptions()
            markerOptions.apply {
                title("Current Location")
                position(latLng)
                icon(BitmapDescriptorFactory.defaultMarker())
                snippet("My Location")
            }

            if(mMarker != null){
                mGoogleMap.clear()
            }

            val markerCurrent: View = (requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.current_location_marker_layout, null)

            val markerVictim: View = (requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.custom_marker_layout, null)

            val markerVolunteer: View = (requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.custom_marker_volunteer_layout, null)

           /* val numTxt: TextView = marker.findViewById<View>(R.id.tvPostImageUsername) as TextView
            numTxt.setText("Pankaj Mangal")*/

            val latLng1 = LatLng(29.396158, 75.343186)
            val latLng2 = LatLng(29.377643, 75.345179)
            val latLng3 = LatLng(29.403543, 75.357250)
            val latLng4 = LatLng(29.392369, 75.368793)
            val latLng5 = LatLng(29.409144, 75.328933)


            mMarker = mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerCurrent)))
            )

            mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng1)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerVictim)))
            )
            mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng2)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerVolunteer)))
            )
            mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng3)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerVolunteer)))
            )

            mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng4)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerVolunteer)))
            )

            mGoogleMap.addMarker(
                MarkerOptions()
                    .position(latLng5)
                    .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(requireActivity(), markerVolunteer)))
            )
//            mMarker =  mGoogleMap.addMarker(markerOptions)
            val geofence = createGeoFence(mMarker!!.position, 5000f)
            val geoFenceRequest = GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofence(geofence)
                .build()

            LocationServices.GeofencingApi.addGeofences(mGoogleApiClient, geoFenceRequest,
                createGeofencingPendingIntent()).setResultCallback(this)

        }else{
            Log.e("Location failed", " :: Your location not get at this point....")
        }
    }

    private fun createGeoFence(
        position: LatLng,
        fl: Float
    ) : Geofence{
        val geofence = Geofence.Builder()
            .setRequestId("My Geofence ID")
            .setCircularRegion(position.latitude, position.longitude, fl)
            .setExpirationDuration(60*60*1000)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
            .build()

        return geofence
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            MY_PERMISSIONS_REQUEST_FINE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("location permission", " :: Location permission granted !!")
                    // permission was granted

                } else {
                    Log.e("location permission", " :: Location permission not granted !!")
                    // permission was denied
                }
            }
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        return true
    }

    private var geofenceMarker:Marker ?= null
    override fun onMapClick(latLng: LatLng?) {
       val markerOptions = MarkerOptions()
        markerOptions.apply {
            position(latLng!!)
            title("Geofence Marker")
        }

        if(geofenceMarker != null){
            geofenceMarker!!.remove()
        }

        geofenceMarker = mGoogleMap.addMarker(markerOptions)
        /*val geofence = createGeoFence(mMarker!!.position, 500f)
        val geoFenceRequest = GeofencingRequest.Builder()
            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
            .addGeofence(geofence)
            .build()

        LocationServices.GeofencingApi.addGeofences(mGoogleApiClient, geoFenceRequest,
            createGeofencingPendingIntent()).setResultCallback(this)*/
    }

    private var geofencePendingIntent:PendingIntent ?= null
    private fun createGeofencingPendingIntent() : PendingIntent{

        if(geofencePendingIntent != null){
            return geofencePendingIntent!!
        }

       /* activity?.let {

        }*/

        val pendingIntent = Intent(requireActivity(), GeofenceTransitionServices::class.java)
        return PendingIntent.getService(requireContext(), 101, pendingIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    override fun onResult(p0: Status) {
        drawGeofence()
    }

    private var geofenceLimits:Circle ?= null
    private fun drawGeofence() {
        if(geofenceLimits != null){
            geofenceLimits!!.remove()
        }

        val circleOptions = CircleOptions()
                circleOptions.apply {
                    center(mMarker?.position)
                    strokeWidth(4f)
                    strokeColor(Color.parseColor("#ff0000"))
                    fillColor(Color.parseColor("#22adadad"))
                    radius(5000.0)
                }
        geofenceLimits = mGoogleMap.addCircle(circleOptions)
    }
}
