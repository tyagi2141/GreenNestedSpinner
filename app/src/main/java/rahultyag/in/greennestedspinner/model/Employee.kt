import com.google.gson.annotations.SerializedName


data class Employee (

	@SerializedName("area") val area : String,
	@SerializedName("name") val name : String,
	@SerializedName("territory") val territory : String
)