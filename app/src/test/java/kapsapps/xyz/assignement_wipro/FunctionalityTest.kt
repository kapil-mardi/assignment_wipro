package kapsapps.xyz.assignement_wipro

import kapsapps.xyz.assignement_wipro.modal.BaseModal
import kapsapps.xyz.assignement_wipro.service.Client
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FunctionalityTest {

    //test to check if client class and URL works
    @Test
    fun checkResponse(){

        val client = Client.getClient()

        client?.getFacts()?.enqueue(object : Callback<BaseModal>{

            override fun onResponse(call: Call<BaseModal>, response: Response<BaseModal>) {

                System.out.println(response.body()?.toString())
            }

            override fun onFailure(call: Call<BaseModal>, t: Throwable) {
                System.out.println(t.localizedMessage)
            }
        })


        //adding some timeout as above call is asynchronous and execution will not wait for the call to finish
        try{

            Thread.sleep(3 * 1000)

        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}

