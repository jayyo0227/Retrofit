package jayyo.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.Format

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message: TextView = findViewById(R.id.message)

        val callAPI: Button = findViewById(R.id.callAPI)
        callAPI.setOnClickListener {
            val apiService = AppClientManager.client.create(ApiService::class.java).apply {
                index().enqueue(object : Callback<List<Gets>> {
                    override fun onResponse(call: Call<List<Gets>>, response: Response<List<Gets>>) {
                        val sb = StringBuffer()
                        val list = response.body()
                        for (p in list!!) {
                            sb.append(p.body)
                            sb.append("\n")
                            sb.append("---------------------\n")
                        }
//                        message.text = sb.toString()
                    }

                    override fun onFailure(call: Call<List<Gets>>, t: Throwable) {

                    }
                })
            }

            val apiServiceForYouBike = AppClientManager.clientForYouBike.create(ApiService::class.java).apply {
                youBikeTP().enqueue(object : Callback<Posts> {
                    override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                        val sb = StringBuffer()
                        val list = response.body()
                        val jsonObject = JSONObject(list?.retVal.toString()) //自己拆解JSON
                        for (i in 0..jsonObject.length()) {
                            val jsonObjectKey: String = String.format("%04d", i + 1 )
                            Log.d("dev", jsonObjectKey)

                            if (jsonObject.isNull(jsonObjectKey)){
                                continue //如果這個 key is Null 跳下一個
                            }

                            val sna = jsonObject.getJSONObject(jsonObjectKey).getString("sna")
                            Log.d("dev", sna)

                            sb.append(sna)
                            sb.append("\n")
                            sb.append("---------------------\n")
                        }
                        message.text = sb.toString()
                    }

                    override fun onFailure(call: Call<Posts>, t: Throwable) {
                        Log.d("dev", t.toString())
                    }
                })
            }
        }


    }
}