package kapsapps.xyz.assignement_wipro.modal


import com.google.gson.annotations.SerializedName

data class Row(
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageHref")
    val imageHref: String?,
    @SerializedName("title")
    val title: String?
)