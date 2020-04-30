package com.saarthiapp.android.model.feed

data class FeedPost(
    var postName:String,
    var postLocation:String,
    var type:String,
    var mediaContent:String,
    var thumbnail:String,
    var desc:String
) {
}