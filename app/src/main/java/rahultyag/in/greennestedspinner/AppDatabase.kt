package rahultyag.`in`.greennestedspinner

import Area
import Country
import Employee
import Region
import Zone
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Area::class,Country::class,Employee::class,Region::class,Zone::class), version = 2, exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {

    abstract fun dao_data(): DaoData

    private var mInstance: AppDatabase? = null

        companion object {
            private var INSTANCE: AppDatabase? = null
            fun getDatabase(context: Context): AppDatabase? {
                if (INSTANCE == null) {
                    synchronized(AppDatabase::class) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "Reports.db"
                        ).allowMainThreadQueries().build()
                    }
                }
                return INSTANCE
            }
        }

     fun destroyInstance() {
        mInstance = null
    }
}