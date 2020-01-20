package kapsapps.xyz.assignement_wipro.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kapsapps.xyz.assignement_wipro.modal.BaseModal
import kapsapps.xyz.assignement_wipro.service.ServiceCaller


class DataViewModal() : ViewModel(){


    val factsList : MutableLiveData<BaseModal> = MutableLiveData()


    fun getFactsList() : LiveData<BaseModal>{

        if(factsList.value == null){
            loadFactsData()
        }

        return factsList
    }

    fun loadFactsData(){
        ServiceCaller().getData()
            .subscribe(
                {
                    factsList.value = it
                }
            )
    }


}