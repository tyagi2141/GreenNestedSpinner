import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Employee")
data class Employee (

	@PrimaryKey(autoGenerate = true)
	var id: Int,

	@ColumnInfo @SerializedName("area") val area : String,
	@ColumnInfo	@SerializedName("name") val name : String,
	@ColumnInfo	@SerializedName("territory") val territory : String
)