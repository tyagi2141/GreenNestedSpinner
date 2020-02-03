package rahultyag.`in`.greennestedspinner

import android.app.Application
import com.facebook.stetho.Stetho

class SearchableSpinnerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
