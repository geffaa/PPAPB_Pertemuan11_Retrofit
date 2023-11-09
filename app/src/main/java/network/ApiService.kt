package network


import model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    fun getAllUsers(): Call<Users>

}