import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Region")

data class Region (
	@PrimaryKey(autoGenerate = true)
	var id: Int,
	@ColumnInfo @SerializedName("region") val region : String,
	@ColumnInfo	@SerializedName("territory") val territory : String
)