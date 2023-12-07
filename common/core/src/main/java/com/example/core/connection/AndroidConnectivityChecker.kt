package com.example.core.connection

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class AndroidConnectivityChecker @Inject constructor(
    private val context: Context
) : ConnectivityChecker {

    override fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}