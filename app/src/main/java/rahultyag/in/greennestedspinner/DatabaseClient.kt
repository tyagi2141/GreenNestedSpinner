package rahultyag.`in`.greennestedspinner

import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(mCtx: Context) {
    //our app database object
   /* val appDatabase: AppDatabase

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }

    init {

        appDatabase =
            Room.databaseBuilder(mCtx.applicationContext, AppDatabase::class.java, "Reports").allowMainThreadQueries()
                .build()
    }*/
}