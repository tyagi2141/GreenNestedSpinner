import com.google.gson.annotations.SerializedName


data class Json4Kotlin_Base(



    @SerializedName("ResponseStatus") val responseStatus: Int,
    @SerializedName("ResponseData") val responseData: ResponseData,
    @SerializedName("Success") val success: Boolean
)