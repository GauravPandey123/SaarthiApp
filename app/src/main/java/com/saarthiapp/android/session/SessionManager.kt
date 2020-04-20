import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Singleton
class SessionManager
@Inject
constructor(
    val application: Application
) {
    companion object {
        const val APP_PREFERENCES: String = "com.sharthiapp.android.APP_PREFERENCES"


    }





    fun isConnectedToTheInternet(): Boolean{
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try{
            return cm.activeNetworkInfo.isConnected
        }catch (e: Exception){
            Log.e(ContentValues.TAG, "isConnectedToTheInternet: ${e.message}")
        }
        return false
    }

}


