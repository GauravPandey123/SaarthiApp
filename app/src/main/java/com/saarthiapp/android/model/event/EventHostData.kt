package com.saarthiapp.android.model.event

data class EventHostData(
    var eventID:Int,
    var eventImage:String ?= null,
    var eventTitle:String ?= null,
    var eventDesc:String ?= null,
    var joinedMember:Int ?= null
) {
}