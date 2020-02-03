package rahultyag.`in`.greennestedspinner

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        fun create(): IRetrofit {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://demo1929804.mockable.io/")
                .build()
            return retrofit.create(IRetrofit::class.java!!)
        }
    }
}
