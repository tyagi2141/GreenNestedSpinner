import com.google.gson.annotations.SerializedName


data class Area (

	@SerializedName("area") val area : String,
	@SerializedName("territory") val territory : String
)