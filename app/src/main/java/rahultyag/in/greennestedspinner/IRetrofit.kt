package rahultyag.`in`.greennestedspinner

import Json4Kotlin_Base
import io.reactivex.Observable
import retrofit2.http.GET

interface IRetrofit {
    @GET("assignment")
    fun getData() : Observable<Json4Kotlin_Base>
}
