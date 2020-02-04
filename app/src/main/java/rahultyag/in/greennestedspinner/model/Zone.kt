
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Zone")
data class Zone (
	@PrimaryKey(autoGenerate = true)
	var id: Int,

	@ColumnInfo @SerializedName("zone") val zone : String,
	@ColumnInfo	@SerializedName("territory") val territory : String
)