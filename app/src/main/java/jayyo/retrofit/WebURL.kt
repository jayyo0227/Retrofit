package jayyo.retrofit

object WebURL {

    const val OpenData_YouBikeTP = "https://tcgbusfs.blob.core.windows.net/blobyoubike/YouBikeTP.json"
    /**
     * Retrofit 的 baseUrl 只能放 資料夾 的路徑，而且只能抓到 第一個斜線 也就是最基層的資料夾
     */
    const val OpenData_Dir = "https://tcgbusfs.blob.core.windows.net/"
    const val JSONFileName = "/blobyoubike/YouBikeTP.json"

    const val TestJSONData = "https://jsonplaceholder.typicode.com/posts"
    const val TestDir = "https://jsonplaceholder.typicode.com"
    const val TestFileName = "/posts"

}