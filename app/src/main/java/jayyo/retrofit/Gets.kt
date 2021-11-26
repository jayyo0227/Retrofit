package jayyo.retrofit

import com.google.gson.annotations.SerializedName

class Gets {
    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("body")
    var body: String? = null
}