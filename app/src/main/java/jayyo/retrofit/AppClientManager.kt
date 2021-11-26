package jayyo.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private val retrofit: Retrofit
    private val retrofitForYouBike: Retrofit
    private val okHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(WebURL.TestDir)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofitForYouBike = Retrofit.Builder()
            .baseUrl(WebURL.OpenData_Dir)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object { //Kotlin 的 單例模式
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
        val clientForYouBike: Retrofit
            get() = manager.retrofitForYouBike
    }

}
