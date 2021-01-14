package com.rikihikmianto.covid_19.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rikihikmianto.covid_19.adapter.ProvinsiAdapter
import com.rikihikmianto.covid_19.api.RetrofitClient
import com.rikihikmianto.covid_19.databinding.ActivityProvinsiBinding
import com.rikihikmianto.covid_19.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProvinsiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showProvinsi()
    }

    private fun showProvinsi() {
        binding.rvProvinsi.setHasFixedSize(true)
        binding.rvProvinsi.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvinsi().enqueue(object : Callback<ArrayList<ProvinsiResponse>>{
            override fun onResponse(call: Call<ArrayList<ProvinsiResponse>>, response: Response<ArrayList<ProvinsiResponse>>) {
                val list = response.body()
                val adapter = list?.let { ProvinsiAdapter(it) }
                binding.rvProvinsi.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinsiResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinsiActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}