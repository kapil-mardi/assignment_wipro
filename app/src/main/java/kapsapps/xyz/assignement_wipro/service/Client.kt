package kapsapps.xyz.assignement_wipro.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* This class provides basic Retrofit instance for given BASE URL
* */
class Client{

    companion object Provider {
        private var client : Retrofit? = null

        fun getClient() : Services? {
            client ?: synchronized(this){
                client = createClient()
            }

            return client?.create(Services::class.java)
        }

        private fun createClient() = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}