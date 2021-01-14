package com.rikihikmianto.covid_19.page

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rikihikmianto.covid_19.api.RetrofitClient
import com.rikihikmianto.covid_19.databinding.ActivityMainBinding
import com.rikihikmianto.covid_19.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showIndonesia()

        binding.button.setOnClickListener {
            Intent(this@MainActivity, ProvinsiActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia().enqueue(object :
                Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positif = indonesia?.positif
                val meninggal = indonesia?.meninggal
                val dirawat = indonesia?.dirawat
                val sembuh = indonesia?.sembuh

                binding.positif.text = positif
                binding.sembuh.text = sembuh
                binding.dirawat.text = dirawat
                binding.meninggal.text = meninggal
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}