package com.saarthiapp.android.ui.home.geofenceServices

import android.app.IntentService
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent

class GeofenceTransitionServices(serviceName:String) : IntentService(serviceName) {


    override fun onHandleIntent(p0: Intent?) {
        val geofencingEvent = GeofencingEvent.fromIntent(p0)

        if(geofencingEvent.hasError()){
            val errorCode = geofencingEvent.errorCode
            Log.e("geofencing error Code", " :: $errorCode")
            return
        }

        val geofenceTransitions:Int = geofencingEvent.geofenceTransition
        if(geofenceTransitions == Geofence.GEOFENCE_TRANSITION_ENTER || geofenceTransitions == Geofence.GEOFENCE_TRANSITION_EXIT){
            val triggeringGeofencing:List<Geofence> = geofencingEvent.triggeringGeofences
            val geofenceDetails:String = getGeofenceTransitionDetails(geofenceTransitions, triggeringGeofencing)
        }
    }

    private fun getGeofenceTransitionDetails(
        geofenceTransitions: Int,
        triggeringGeofencing: List<Geofence>
    ): String {
        val triggeringGeoFenceList = ArrayList<String>()
        for(geofence:Geofence in triggeringGeofencing){
            triggeringGeoFenceList.add(geofence.requestId)
        }

        var status:String ?= null

        if(geofenceTransitions == Geofence.GEOFENCE_TRANSITION_ENTER){
            status = "Enter into geofence area"
        }else if(geofenceTransitions == Geofence.GEOFENCE_TRANSITION_EXIT){
            status = "Exit from geofence area"
        }

        return status+TextUtils.join(", ", triggeringGeoFenceList)
    }
}