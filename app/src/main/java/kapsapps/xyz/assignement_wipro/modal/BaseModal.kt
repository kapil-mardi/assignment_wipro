package kapsapps.xyz.assignement_wipro.modal


import com.google.gson.annotations.SerializedName

data class BaseModal(
    @SerializedName("rows")
    val rows: List<Row?>?,
    @SerializedName("title")
    val title: String?
)