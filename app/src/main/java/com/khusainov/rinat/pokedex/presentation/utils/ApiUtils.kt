package com.khusainov.rinat.pokedex.presentation.utils

import com.google.gson.Gson
import com.khusainov.rinat.pokedex.Constants
import com.khusainov.rinat.pokedex.data.api.PokedexApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {
    private var retrofit: Retrofit? = null
    private var gson: Gson? = null
    private var api: PokedexApi? = null

    private fun getRetrofit(): Retrofit {
        if (gson == null) {
            gson = Gson()
        }

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getApi(): PokedexApi {
        if (api == null) {
            api = getRetrofit().create(PokedexApi::class.java)
        }
        return api!!
    }
}