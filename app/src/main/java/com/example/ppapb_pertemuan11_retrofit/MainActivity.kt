package com.example.ppapb_pertemuan11_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ppapb_pertemuan11_retrofit.databinding.ActivityMainBinding
import model.Users
import network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<String>()

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                for (i in response.body()!!.data) {
                    userList.add(i.employee_name)
                }

                val listAdapter =
                    ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, userList)
                binding.lvNama.adapter = listAdapter
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
