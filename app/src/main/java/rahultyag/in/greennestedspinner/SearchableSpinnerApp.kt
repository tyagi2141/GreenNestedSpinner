package rahultyag.`in`.greennestedspinner

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import java.lang.System.`in`

class SearchableSpinnerApp : Application() {
    private var mDB: AppDatabase? = null
    private val context: Context? = null

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
      AppDatabase.getDatabase(this)
    }
    init {
        instance = this
    }

    companion object {
        private var instance: SearchableSpinnerApp? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    @Synchronized
    fun getDB(): AppDatabase? {
        if (mDB == null) {
           mDB =
               context?.let { AppDatabase.getDatabase(it) }
        }
        return mDB
    }
}
