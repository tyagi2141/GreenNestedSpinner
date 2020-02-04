import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Country")
data class Country (

	@PrimaryKey(autoGenerate = true)
	var id: Int,

	@ColumnInfo @SerializedName("country") val country : String,
	@ColumnInfo @SerializedName("territory") val territory : String
)