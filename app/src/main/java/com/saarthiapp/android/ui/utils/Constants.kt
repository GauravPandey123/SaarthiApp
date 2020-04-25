package com.saarthiapp.android.ui.utils

class Constants {

    companion object{

        const val BASE_URL = "https://sarrthi.online/api/"
        const val PASSWORD_RESET_URL: String = "https://open-api.xyz/password_reset/"

        const val NETWORK_TIMEOUT = 6000L
        const val TESTING_NETWORK_DELAY = 0L // fake network delay for testing
        const val TESTING_CACHE_DELAY = 0L // fake cache delay for testing

        const val PAGINATION_PAGE_SIZE = 10

        const val GALLERY_REQUEST_CODE = 201
        const val PERMISSIONS_REQUEST_READ_STORAGE: Int = 301
        const val CROP_IMAGE_INTENT_CODE: Int = 401

        //Meow Bottom Navigation IDs here....
        const val MEOW_HOME_BOTTOM_NAVIGATION = 0
        const val MEOW_OUT_WORK_BOTTOM_NAVIGATION = 1
        const val MEOW_CHAT_BOTTOM_NAVIGATION = 2
        const val MEOW_PROFILE_BOTTOM_NAVIGATION = 3
    }
}