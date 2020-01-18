package kapsapps.xyz.assignement_wipro.service

import kapsapps.xyz.assignement_wipro.modal.BaseModal
import retrofit2.Call
import retrofit2.http.GET

/*
* This interface defines basic contract between client and the REST API
* */
interface Services{

    //Get the fasts and convert them to BaseModal
    @GET("facts.json")
    fun getFacts() : Call<BaseModal>
}