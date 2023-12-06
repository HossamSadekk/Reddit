package com.example.remote.helper

import com.example.remote.interceptor.HttpRequestInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

private const val CLIENT_TIME_OUT = 60L


fun createHttpRequestInterceptor(): HttpRequestInterceptor {
    return HttpRequestInterceptor()
}


fun createOkHttpClient(
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        addInterceptor(createHttpRequestInterceptor())
        //specifies the maximum amount of time that OkHttp will wait for the server to respond to the connection request
        connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        //controls how long OkHttp will wait for the response data to be sent by the server.
        readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        //OkHttp will wait to send data to the server before giving up and throwing a SocketTimeoutException.
        writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
    }.build()
}