package kapsapps.xyz.assignement_wipro.service

import io.reactivex.Observable
import kapsapps.xyz.assignement_wipro.modal.BaseModal
import kapsapps.xyz.assignement_wipro.modal.Row
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class ServiceCaller() {

    fun getData() : Observable<BaseModal?> = Observable.create {

            Client.getClient()?.getFacts()?.enqueue(object : Callback<BaseModal>{

                override fun onFailure(call: Call<BaseModal>, t: Throwable) {
                    it.onError(t)
                }

                override fun onResponse(call: Call<BaseModal>, response: Response<BaseModal>) {
                    if(response.isSuccessful){
                        it.onNext(response.body() ?: BaseModal(listOf(Row("","","")),""))
                        it.onComplete()
                    }else{
                        it.onError(Exception("Response was not successful"))
                    }

                }
            })
        }
}