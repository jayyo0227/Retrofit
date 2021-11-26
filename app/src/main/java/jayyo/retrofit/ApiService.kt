package jayyo.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun index(): Call<List<Gets>>

    @GET("/blobyoubike/YouBikeTP.json")
    fun youBikeTP(): Call<Posts>
}