import com.google.gson.annotations.SerializedName


data class Country (

	@SerializedName("country") val country : String,
	@SerializedName("territory") val territory : String
)