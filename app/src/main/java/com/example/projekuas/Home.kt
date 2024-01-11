package com.example.projekuas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.projekuas.adapter.Adapter
import com.example.projekuas.config.DataConfig
import com.example.projekuas.data.ModelListGempa
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val _listview = view.findViewById<ListView>(R.id.list_gempa)



        DataConfig()
            .getService()
            .getDataGempa()
            .enqueue(object : Callback<ModelListGempa> {
                override fun onResponse(
                    call: Call<ModelListGempa>,
                    response: Response<ModelListGempa>
                ) {
                    Log.d("Bariq", "data.json: " + response.body())
                    _listview.adapter = Adapter(response.body(), this@Home,
                        response.body()?.infogempa?.gempa!!
                    )
                    Log.d("Bariq ", "Adapter beres")
                }

                override fun onFailure(call: Call<ModelListGempa>, t: Throwable) {
                    Log.d("Bariq", "error: " + t.message.toString())
                }

            })

        return view

    }
}