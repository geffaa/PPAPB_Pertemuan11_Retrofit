package model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("employee_name")
    val employee_name: String,
    @SerializedName("employee_salary")
    val employee_salary: Int,
    @SerializedName("employee_age")
    val employee_age: Int,
    @SerializedName("profile_image")
    val profile_image: String
)
