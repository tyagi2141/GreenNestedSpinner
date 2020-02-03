import com.google.gson.annotations.SerializedName




data class ResponseData (

	@SerializedName("country") val country : List<Country>,
	@SerializedName("zone") val zone : List<Zone>,
	@SerializedName("region") val region : List<Region>,
	@SerializedName("area") val area : List<Area>,
	@SerializedName("employee") val employee : List<Employee>
)