package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Base URL for the raw JSON.
private const val BASE_URL =
    "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"


// Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


// A Retrofit object with the Moshi converter.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Interface containing declaration of abstract methods and properties.
interface AmphibianApiService {

    // GET is request type and [android-basics-kotlin-unit-4-pathway-2-project-api.json] is the endpoint
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")

    suspend fun getListOfAmphibian(): List<Amphibian>
}

// An object that provides a lazy-initialized retrofit service.
object AmphibianApi {

    //  lazy initialization to make sure it is initialized at its first usage.
    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

}

