import com.google.gson.annotations.SerializedName



data class Region (

	@SerializedName("region") val region : String,
	@SerializedName("territory") val territory : String
)