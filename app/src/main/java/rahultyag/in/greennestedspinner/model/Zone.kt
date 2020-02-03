import com.google.gson.annotations.SerializedName

data class Zone (

	@SerializedName("zone") val zone : String,
	@SerializedName("territory") val territory : String
)